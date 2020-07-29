package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.EquipmentRepository;
import repositories.UserRepository;
import services.EquipmentService;
import services.UserService;
import services.impl.EquipmentServiceImpl;
import services.impl.UserServiceImpl;

@WebServlet("/equipment_add")
public class AddEquipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final EquipmentService equipmentService;
	private final UserService userService;
	private EquipmentRepository equipmentRepository;
	private UserRepository userRep;
	
	
    public AddEquipmentServlet() {
        super();
        this.equipmentService = new EquipmentServiceImpl(new EquipmentRepository());
        this.userService = new UserServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/addEquipment.jsp").forward(request, response);
		
		String username = request.getParameter("username");
		request.getSession().setAttribute("username", username);// username-a shte e na lognatiq potrebitel 
//		String seller = userRep.getUser().getUsername();
//		System.out.println(username);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String equipmentName = request.getParameter("equipmentName");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
//		String pic = request.getParameter("picture");
		String seller = request.getParameter("username");
		
		this.equipmentService.addEquipment(equipmentName, description, price,seller);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
