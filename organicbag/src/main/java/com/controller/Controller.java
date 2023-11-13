package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.model.Database;
import com.model.Product;
import com.model.User;

@WebServlet(urlPatterns = {"/insert", "/logar", "/updatePassword", "/newProduct", "/categoryLink", "/getImage1", "/getImage2", "/getImage3", "/getImage4"})
@MultipartConfig
public class Controller extends HttpServlet{
    private static final long serialVersionUID = 1L;
    Database data = new Database();
    User user = new User();
    Product product = new Product();
    
    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        if(action.equals("/categoryLink")) {
            categoryLink(request, response);
        
        }else if(action.equals("/getImage1")) {
            getImage1(request, response);

        }else if(action.equals("/getImage2")) {
            getImage2(request, response);
        
        }else if(action.equals("/getImage3")) {
            getImage3(request, response);
        
        }else if(action.equals("/getImage4")) {
            getImage4(request, response);
        }
    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        if(action.equals("/insert")) {
            cpfExists(request, response);
        
        }else if(action.equals("/logar")) {
            userLogin(request, response);
        
        }else if(action.equals("/updatePassword")) {
            updatePassword(request, response);

        }else if(action.equals("/newProduct")) {
            newProduct(request, response);

        }
    }

    //Novo usuário
    protected void newUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //teste de recebimento dos dados do formulário
        /*System.out.println(request.getParameter("cpf"));
        System.out.println(request.getParameter("nome"));
        System.out.println(request.getParameter("email"));
        System.out.println(request.getParameter("tel"));
        System.out.println(request.getParameter("optradio"));
        System.out.println(request.getParameter("senha"));*/

        //verificar se usuário já existe
        request.setCharacterEncoding("UTF-8");

        //criar novo objeto usuário
        user.setCpf(request.getParameter("cpf"));
        user.setNome(request.getParameter("nome"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("tel"));
        user.setProfile(request.getParameter("optradio"));

        String passwordEncoded = Base64.getEncoder().encodeToString(request.getParameter("senha").getBytes());
        //String passwordHash = BCrypt.withDefaults().hashToString(12, request.getParameter("senha").toCharArray());
        user.setPassword(passwordEncoded);

        data.createUser(user);

        response.sendRedirect("index.html");
    }

    //verificar se usuário já está cadastrado no banco
    protected void cpfExists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<User> users = data.showUsers();
        PrintWriter out = response.getWriter();

        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");

        boolean exists = false;

        System.out.println("cpf form: " + cpf);

        if(users != null) {
            for(int i = 0; i < users.size(); i++) {
                System.out.println("cpf banco: " + users.get(i).getCpf());
                if(cpf == users.get(i).getCpf() || email.equals(users.get(i).getEmail())) {
                    exists = true;
                    System.out.println("hello");
                    out.println("<!doctype html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Usuário já existe!</title>");
                    out.println("<link rel='stylesheet' href='css/cadastro.css'>");
                    out.println("<link rel='icon' href='img/OrganicBagLogo.png'>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h2>Usuário já existe! <a href='login.html'>Tente logar aqui</a></h2>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }

            if(!exists) {
                System.out.println("não");
                newUser(request, response);
            }

        }else {
            System.out.println("vazio");
            newUser(request, response);
        }
    }

    //logar
    protected void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //System.out.println(request.getParameter("email"));
        PrintWriter out = response.getWriter();

        String password = request.getParameter("senha");

        String email = request.getParameter("email");
        user.setEmail(email);
        data.searchUser(user);

        System.out.println(user.getCpf());
        if(user.getCpf() == null) {
            out.println("<!doctype html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Usuário não existe!</title>");
            out.println("<link rel='stylesheet' href='css/cadastro.css'>");
            out.println("<link rel='icon' href='img/OrganicBagLogo.png'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Usuário não encontrado! <a href='login.html'>Tente novamente</a></h2>");
            out.println("</body>");
            out.println("</html>");

        }else {
            String passwordDecoded = new String(Base64.getDecoder().decode(user.getPassword()));

            if(password.equals(passwordDecoded)) {
                response.sendRedirect("index.html");
            
            }else {
                out.println("<!doctype html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Senha incorreta!</title>");
                out.println("<link rel='stylesheet' href='css/cadastro.css'>");
                out.println("<link rel='icon' href='img/OrganicBagLogo.png'>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Senha incorreta! <a href='login.html'>Tente novamente</a></h2>");
                out.println("</body>");
                out.println("</html>");

                user.setCpf(null);
            }
        }
    }

    //Alterar senha
    protected void updatePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        user.setEmail(email);

        //verificar se usuário existe no banco
        data.searchUser(user);

        //caso não exista
        if(user.getCpf() == null) {
            out.println("<!doctype html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Usuário não existe!</title>");
            out.println("<link rel='stylesheet' href='css/cadastro.css'>");
            out.println("<link rel='icon' href='img/OrganicBagLogo.png'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Usuário não encontrado! <a href='login.html'>Tente novamente</a></h2>");
            out.println("</body>");
            out.println("</html>");

        }else {
            String newPassword = Base64.getEncoder().encodeToString(request.getParameter("senha").getBytes());
            user.setPassword(newPassword);
            user.setEmail(email);

            data.updateData(user);

            System.out.println("boa!");
            response.sendRedirect("index.html");
        }
    }

    //cadastrar produto
    protected void newProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //byte[] image = request.getParameter("img").getBytes();

        Part imagePart = request.getPart("img");
        Part imagePart2 = request.getPart("img2");
        Part imagePart3 = request.getPart("img3");
        Part imagePart4 = request.getPart("img4");

        byte[] image = new byte[(int) imagePart.getSize()];
        imagePart.getInputStream().read(image);

        byte[] image2 = new byte[(int) imagePart2.getSize()];
        imagePart2.getInputStream().read(image2);

        byte[] image3 = new byte[(int) imagePart3.getSize()];
        imagePart3.getInputStream().read(image3);

        byte[] image4 = new byte[(int) imagePart4.getSize()];
        imagePart4.getInputStream().read(image4);

        try {
            Blob blobData = new SerialBlob(image);
            product.setImage(blobData);

            Blob blobData2 = new SerialBlob(image2);
            product.setImage2(blobData2);

            Blob blobData3 = new SerialBlob(image3);
            product.setImage3(blobData3);

            Blob blobData4 = new SerialBlob(image4);
            product.setImage4(blobData4);

        } catch (SerialException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        product.setName(request.getParameter("name"));
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setStock(Integer.parseInt(request.getParameter("qtd")));
        product.setDescription(request.getParameter("desc"));
        product.setCategory(request.getParameter("category"));

        data.addProduct(product);

        //response.sendRedirect("produto.jsp");
        //response.sendRedirect("teste.jsp");
    }

    //coletar informações do link da página do produto selecionado
    protected void categoryLink(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("code"));
        ArrayList<Product> products = data.showProducts();

        int code = Integer.parseInt(request.getParameter("code"));

        for(int i = 0; i < products.size(); i++) {
            if(code == products.get(i).getCode()) {
                //setar as variáveis no objeto product pra acessar na próxima página
                product.setCode(code);
                product.setName(products.get(i).getName());
                product.setPrice(products.get(i).getPrice());
                product.setStock(products.get(i).getStock());
                product.setDescription(products.get(i).getDescription());
                product.setCategory(products.get(i).getCategory());
                product.setImage(products.get(i).getImage());
                product.setImage2(products.get(i).getImage2());
                product.setImage3(products.get(i).getImage3());
                product.setImage4(products.get(i).getImage4());

                request.setAttribute("category", products.get(i).getCategory());
                request.setAttribute("name", products.get(i).getName());
                request.setAttribute("code", products.get(i).getCode());
                request.setAttribute("price", products.get(i).getPrice());
                request.setAttribute("description", products.get(i).getDescription());
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("produto.jsp");
        rd.forward(request, response);
    }

    //coletar imagens do banco
    protected void getImage1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            byte[] imageBytes = product.getImage().getBytes(1, (int) product.getImage().length());
            response.setContentType("image/png");
            response.getOutputStream().write(imageBytes);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void getImage2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            byte[] imageBytes = product.getImage2().getBytes(1, (int)product.getImage2().length());
            response.setContentType("image/png");
            response.getOutputStream().write(imageBytes);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void getImage3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            byte[] imageBytes = product.getImage3().getBytes(1, (int)product.getImage3().length());
            response.setContentType("image/png");
            response.getOutputStream().write(imageBytes);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void getImage4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            byte[] imageBytes = product.getImage4().getBytes(1, (int)product.getImage4().length());
            response.setContentType("image/png");
            response.getOutputStream().write(imageBytes);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
   
}
