package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Equipment;
import repositories.EquipmentRepository;
import services.EquipmentService;
import services.impl.EquipmentServiceImpl;

@WebServlet("/equipment_all")
public class ListEquipmentServlet extends HttpServlet {
	
	private final EquipmentService equipmentService;
	private EquipmentRepository equipmentRepository;
	
	
    public ListEquipmentServlet() {
        super();
        this.equipmentService = new EquipmentServiceImpl(new EquipmentRepository());

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Equipment> allEquipment = this.equipmentService.getAll();
		request.getSession().setAttribute("equipments", allEquipment);
		if(allEquipment.isEmpty()) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
		}
		request.getRequestDispatcher("jsp/listEquipment.jsp").forward(request, response);
	}


}
