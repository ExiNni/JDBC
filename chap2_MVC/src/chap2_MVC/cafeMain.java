package chap2_MVC;

public class cafeMain {

	public static void main(String[] args) {
		cafeModel model = new cafeModel();
		cafeView view = new cafeView(model);
		cafeController controller = new cafeController(model, view);
		controller.run();
		
		// view.addCafeName();
		// view.updateMenu();
		// view.updateOHours();
		// view.deleteCafe();
		// view.deleteMenu();
	}
}

