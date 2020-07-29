package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Equipment;
import repositories.EquipmentRepository;
import services.EquipmentService;
import services.impl.EquipmentServiceImpl;

@WebServlet("/singleEquipment/*")
public class SingleEquipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final EquipmentService equipmentService;
	private EquipmentRepository equipmentRepository;
	
    public SingleEquipmentServlet() {
        super();
        this.equipmentService = new EquipmentServiceImpl(new EquipmentRepository());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String itemId = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
		Equipment item = this.equipmentService.getById(Integer.parseInt(itemId));
		
		request.getSession().setAttribute("item", item);
		request.getRequestDispatcher("jsp/singleEquipmentPage.jsp").forward(request, response);
		
	}




}
