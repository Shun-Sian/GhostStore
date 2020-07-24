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
import utils.RequestIOUtils;

@WebServlet("/equipment/*")
public class EquipmentServlet extends HttpServlet {
	
    private final EquipmentService equipmentService;
    private EquipmentRepository equipmentRepository;

    public EquipmentServlet() {  
        super();
        this.equipmentService = new EquipmentServiceImpl(new EquipmentRepository());
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = ((HttpServletRequest)req).getRequestURL().toString();
        String[] urlParts = url.split("/");
        String lastPart = urlParts[urlParts.length - 1];
        switch (lastPart) {
            case "all" : {
                List<Equipment> allEquipment = equipmentService.getAll();
            }
            default: return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Equipment equipment = RequestIOUtils.parseJSONtoObject(req, Equipment.class);
        this.equipmentService.addEquipment(equipment);
    }
}
