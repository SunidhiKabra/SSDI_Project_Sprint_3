package api;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import dao.*;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean begin;

	public void init() throws ServletException {
		DAO dao = new DAO();
		Action.add(new ViewItemController(dao));
		Action.add(new HomePageController());
		Action.add(new ViewRenterController(dao));
		Action.add(new LoginController(dao));
		Action.add(new LogoutController());
		Action.add(new AddItemController(dao));
		Action.add(new MyPostingsController(dao));
		Action.add(new UpdatePostingsController(dao));
		Action.add(new DeleteItemController(dao));
		Action.add(new ViewAccountInfoController(dao));
		Action.add(new EditInformationController(dao));
		Action.add(new SignUpController(dao));
		Action.add(new DeleteItemFromWishlistController(dao));
		Action.add(new AddItemToWishlistController(dao));
		Action.add(new ViewWishlistController(dao));
		begin = false;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = performTheAction(request);
		sendToNextPage(nextPage, request, response);
	}

	/*
	 * Extracts the requested action and (depending on whether the user is logged
	 * in) perform it (or make the user login).
	 * 
	 * @param request
	 * 
	 * @return the next page (the view)
	 */
	private String performTheAction(HttpServletRequest request) {

		String servletPath = request.getServletPath(); // gets the URL

		String action = getActionName(servletPath); // gets the action name from the URL

		if (action.equals("signUp.do")) {
			// Allow these actions without logging in
			return Action.perform(action, request);
		}
		HttpSession session = request.getSession(true); // request session
		ICustomer loggedInUser = (ICustomer) session.getAttribute("loggedInUser"); // get value of logged in user from
																					// the session

		if (loggedInUser == null) {
			// If the user hasn't logged in, so login is the only option
			return Action.perform("login.do", request);
		}

		// Let the logged in user run his chosen action
		request.setAttribute("loggedInUser", loggedInUser);
		return Action.perform(action, request);
	}

	/*
	 * If nextPage is null, send back 404 If nextPage ends with ".do", redirect to
	 * this page. If nextPage ends with ".jsp", dispatch (forward) to the page (the
	 * view) This is the common case
	 */
	private void sendToNextPage(String nextPage, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (nextPage == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, request.getServletPath());
			return;
		}

		if (nextPage.endsWith(".do")) {
			response.sendRedirect(nextPage);
			return;
		}

		if (nextPage.endsWith(".jsp")) {
			// RequestDispatcher d = request.getRequestDispatcher("WEB-INF/" + nextPage);
			RequestDispatcher d = request.getRequestDispatcher(nextPage);
			d.forward(request, response);
			return;
		}
		if (nextPage.endsWith(".msg")) {
			response.getWriter().write(getMessage(nextPage));
			return;
		}

		throw new ServletException(
				Controller.class.getName() + ".sendToNextPage(\"" + nextPage + "\"): invalid extension.");

	}

	/*
	 * Returns the path component after the last slash removing any "extension" if
	 * present.
	 */
	private String getActionName(String path) {
		// We're guaranteed that the path will start with a slash
		int slash = path.lastIndexOf('/');
		return path.substring(slash + 1);
	}

	private String getMessage(String message) {

		return message.replace(".msg", "");
	}
}