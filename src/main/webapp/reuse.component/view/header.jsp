  <%@ page import="utils.*,bean.*" %>
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="./home">Noof Store</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
        aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Services</a>
          </li>
          <li class="nav-item">
          <%User user = (User) request.getAttribute("userObj");
          if(user == null){%>
            <a class="nav-link" href="./login">Login</a>
          <%}else{%>
        	  <a class="nav-link" href="./login?action=logout">
        	  <%=user.getName()== null ? "User" : user.getName()%>, logout!
        	  </a>
          <%} %>
          </li>
        </ul>
      </div>
    </div>
  </nav>