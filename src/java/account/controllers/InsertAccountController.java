/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tram.daos.UserDAO;
import tram.dtos.UserDTO;
import tram.dtos.UserErrorObject;

/**
 *
 * @author Tammy Phan
 */
public class InsertAccountController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "login.jsp";
    private static final String INVALID = "user/insertUser.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            boolean valid = true;
            UserErrorObject errorObj = new UserErrorObject();
            String id = request.getParameter("id").trim();
            String password = request.getParameter("password").trim();
            String confirm = request.getParameter("confirm").trim();
            String fullname = request.getParameter("fullname").trim();
            String email = request.getParameter("email").trim();
            String phone = request.getParameter("phone").trim();
            Date dob = new Date(0, 0, 0);
            if (id.length() < 3) {
                valid = false;
                errorObj.setIdError("Username is required, minimum 3 chars");
            }
            if (password.length() < 3) {
                valid = false;
                errorObj.setPasswordError("Password is required, minimum 3 chars");
            }
            if (!confirm.equals(password)) {
                valid = false;
                errorObj.setConfirmError("Password isn't match");
            }
            if (fullname.length() < 3) {
                valid = false;
                errorObj.setFullnameError("Fullname is required, minimum 3 chars");
            }
            if (!email.matches("^[a-zA-Z0-9._]{3,20}[@][a-z]{2,6}([.][a-z]{2,6}){1,2}$")) {
                valid = false;
                errorObj.setEmailError("Invalid email");
            }
            if (!phone.matches("^[0-9]{10}$")) {
                valid = false;
                errorObj.setPhoneError("Phone is required, must be 10 numbers");
            }
            //validate date
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String tmpDate = fmt.format(Calendar.getInstance().getTime());
            Date currentDate = new Date(fmt.parse(tmpDate).getTime());
            try {
                fmt.setLenient(false);
                dob = new Date(fmt.parse(request.getParameter("dob").trim()).getTime());
                if (dob.after(currentDate)) {
                    valid = false;
                    errorObj.setDobError("Invalid date of birth");
                } else {
                    int curYear = Calendar.getInstance().get(Calendar.YEAR);
                    Calendar tmpDOB = Calendar.getInstance();
                    tmpDOB.setTime(dob);
                    int birthYear = tmpDOB.get(Calendar.YEAR);
                    int age = curYear - birthYear;
                    if (age < 16) {
                        valid = false;
                        errorObj.setDobError("Must more than 16 years old");
                    }
                }
            } catch (ParseException e) {
                valid = false;
                errorObj.setDobError("Date of birth is invalid (yyyy-mm-dd)");
            }
            if (valid) {
                UserDAO dao = new UserDAO();
                UserDTO dto = new UserDTO(id, fullname, email, phone, dob);
                dto.setPassword(password);
                if (dao.insert(dto)) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Insert User Failed");
                }
            } else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            log("ERROR AT InsertAccontController: " + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                url = INVALID;
                UserErrorObject errorObj = new UserErrorObject();
                errorObj.setIdError("This Account is existed");
                request.setAttribute("INVALID", errorObj);
            }
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
