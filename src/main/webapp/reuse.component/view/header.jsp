  <%@ page import="utils.*,bean.*" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/MobileShop/home">Noof Store</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
        aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Shop
              <span class="sr-only">(current)</span>
            </a>
          </li>
          
          
          <li class="nav-item">
              <!-- Another variation with a button -->
			 <!--  <div class="input-group">
			    <input type="text" class="form-control" placeholder="Search something">
			    <div class="input-group-append">
			      <button class="btn btn-secondary" type="button">
			        <i class="fa fa-search"></i>
			      </button>
			    </div>
			  </div>--> 
			  
			  <div class="input-group">
			    <form style="display:flex" action="/MobileShop/search" method="POST">
			      <input type="text" class="form-control" placeholder="Search this blog" name="search">
			      <div class="input-group-append">
			        <button class="btn btn-secondary" type="submit">
			          <i class="fa fa-search"></i>
			        </button>
			      </div>
			    </form>
			  </div>  
			  
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="/MobileShop/cart"><i class="fas fa-shopping-cart"></i></a>
          </li>
          <li class="nav-item">
          <%UserModel user = (UserModel) request.getAttribute("userObj");
          if(user == null){%>
            <a class="nav-link" href="/MobileShop/login">Login</a>
          <%}else{%>
        	  <a class="nav-link" href="/MobileShop/login?action=logout">
        	  <%=user.getName()== null || user.getName().isEmpty() ? user.getUsername() : user.getName()%>, logout!
        	  </a>
          <%} %>
          </li>
        </ul>
      </div>
    </div>
  </nav>