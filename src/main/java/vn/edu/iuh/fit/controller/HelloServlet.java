package vn.edu.iuh.fit.controller;

import java.io.*;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.ws.rs.GET;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.models.Roles;
import vn.edu.iuh.fit.repositories.CandidateRepository;

@WebServlet(name = "home", value = "/home")
public class HelloServlet extends HttpServlet {
    private final CandidateRepository candidateRepository = new CandidateRepository() ;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action=request.getParameter("action");

        if (action.equals("listCan")){
            List<Candidate> canL = candidateRepository.getAllCan();
            request.setAttribute("listCan", canL);
            request.getRequestDispatcher("/listCan.jsp")
                    .forward(request, response);
        }
        else if (action.equals("viewDetail")){
            long id = Long.parseLong(request.getParameter("id"));
            Candidate canDetail = candidateRepository.getCanById(id).get();
            request.setAttribute("canDetail", canDetail);
            request.getRequestDispatcher("/canDetail.jsp")
                    .forward(request, response);
        }
        else if (action.equals("delete")){
            long id = Long.parseLong(request.getParameter("id"));
            candidateRepository.delete(id);
            List<Candidate> canL = candidateRepository.getAllCan();
            request.setAttribute("listCan", canL);
            request.getRequestDispatcher("/listCan.jsp")
                    .forward(request, response);
        }
        else if (action.equals("update")){
//            long id = Long.parseLong(request.getParameter("id"));
//            candidateRepository.delete(id);
//            List<Candidate> canL = candidateRepository.getAllCan();
//            request.setAttribute("listCan", canL);
            request.getRequestDispatcher("/update.jsp")
                    .forward(request, response);
        }
    }

    public void destroy() {
    }
}