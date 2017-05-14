package com.guitar.action;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guitar.dao.JDBCsqlite;
import com.guitar.model.Guitar;
import com.guitar.model.GuitarSpec;
import com.guitar.model.Inventory;

/**
 * Servlet implementation class GuitarPost
 */
@WebServlet("/GuitarPost")
public class GuitarPost extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuitarPost() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String builder = request.getParameter("规格");
		String type = request.getParameter("分类");
		String backwood = request.getParameter("背侧板材料");
		String topwood = request.getParameter("面板材料");
		

		//根据查询条件，分装成一个查询对象GuitarSpec
		GuitarSpec guitarspec = new GuitarSpec(builder,type,backwood,topwood);
		
		Inventory inventory = new Inventory();
		initializeInventory(inventory);
		
		List<Guitar> matchingGuitars = inventory.search(guitarspec);

		request.setAttribute("matchingGuitar", matchingGuitars);
		request.getRequestDispatcher("/ShowGuitar.jsp").forward(request,response);
	}

	private static void initializeInventory(Inventory inventory){
		Connection connection = null;
		JDBCsqlite jdbc =  new JDBCsqlite();
		PreparedStatement ps = null;
		connection = jdbc.connection;
		
		try {
				ps = connection.prepareStatement("select * from Guitar");
	
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){			
					inventory.addGuitar(rs.getString(1),rs.getDouble(4),rs.getString(6), new GuitarSpec(rs.getString(5),rs.getString(7),rs.getString(2),rs.getString(3)));
				}
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				connection.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
