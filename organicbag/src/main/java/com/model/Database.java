package com.model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Database {
    /* CONEXÃO COM O BANCO */

    //parâmetros de conexão
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/organicbag";
    private String user = "root";
    private String password = "Sbbhqk#203";

    //Método de conexão
    private Connection connect() {

        Connection con = null;
        
        try {
            Class.forName(driver); //lê o driver do banco de dados
            con = DriverManager.getConnection(url, user, password);
            return con;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /* CREATE */
    public void createUser(User user) {
        String create = "insert into usuarios values (?, ?, ?, ?, ?, ?)";

        try {
            Connection con = connect();

            //Preparar a query para executar no banco
            PreparedStatement pst = con.prepareStatement(create);

            pst.setString(1, user.getCpf());
            pst.setString(2, user.getNome());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPhone());
            pst.setString(5, user.getProfile());
            pst.setString(6, user.getPassword());

            //executar a query
            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* READ */
    public ArrayList<User> showUsers() {
        //objeto para acessar a classe User
        ArrayList<User> users = new ArrayList<User>();

        String read = "select * from usuarios";

        try {
            Connection con = connect();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery(); //armazena o retorno do db temporariamente em um objeto

            while(rs.next()) {
                //variáveis de apoio que recebem os dados do banco
                String cpf = rs.getString(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String profile = rs.getString(5);
                String password = rs.getString(6);

                //populando o ArrayList
                User u = new User(cpf, name, email, phone, profile, password);
                users.add(u);
            }

            con.close();

            return users;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //buscar usuário pelo email
    public void searchUser(User user) {
        String search = "select * from usuarios where email = ?";

        try {
            Connection con = connect();

            PreparedStatement pst = con.prepareStatement(search);
            pst.setString(1, user.getEmail());

            ResultSet rs = pst.executeQuery();

            while(rs.next()) {
                user.setCpf(rs.getString(1));
                user.setNome(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPhone(rs.getString(4));
                user.setProfile(rs.getString(5));
                user.setPassword(rs.getString(6));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //alterar campo
    public void updateData(User user) {
        String update = "update usuarios set senha = ? where email = ?";

        try {
            Connection con = connect();

            PreparedStatement pst = con.prepareStatement(update);
            pst.setString(1, user.getPassword());
            pst.setString(2, user.getEmail());

            pst.executeUpdate();

            con.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //cadastrar produto
    public void addProduct(Product product) {
        String create = "insert into produtos (nome, preco, estoque, descricao, categoria, imagem, imagem2, imagem3, imagem4) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = connect();

            //Preparar a query para executar no banco
            PreparedStatement pst = con.prepareStatement(create);

            System.out.println(product.getName());
            pst.setString(1, product.getName());
            pst.setDouble(2, product.getPrice());
            pst.setInt(3, product.getStock());
            pst.setString(4, product.getDescription());
            pst.setString(5, product.getCategory());
            pst.setBlob(6, product.getImage());
            pst.setBlob(7, product.getImage2());
            pst.setBlob(8, product.getImage3());
            pst.setBlob(9, product.getImage4());

            //executar a query
            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Product> showProducts() {
        ArrayList<Product> products = new ArrayList<Product>();

        String read = "select * from produtos";

        try {
            Connection con = connect();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int code = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                int stock = rs.getInt(4);
                String description = rs.getString(5);
                String category = rs.getString(6);
                Blob image1 = rs.getBlob(7);
                Blob image2 = rs.getBlob(8);
                Blob image3 = rs.getBlob(9);
                Blob image4 = rs.getBlob(10);

                Product p = new Product(code, name, price, stock, description, category, image1, image2, image3, image4);
                products.add(p);
            }

            return products;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
