<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags"	prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="info" property="principal" />
<!DOCTYPE html>
<html>
    <head>
        <title><tiles:getAsString name="title"/></title>
        <tiles:insertDefinition name="css" />
         <tiles:insertDefinition name="script"/>
    </head>
    <body>
    
     <div id="wrapper">

        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/"><tiles:getAsString name="title"/></a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
       
                 <!-- /.dropdown-user -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
	                     <%-- <sec:authorize access="hasRole('ROLE_USER')"> --%>
	                     <sec:authorize access="hasAnyRole('ROLE_ADM', 'ROLE_USR')">
	                        <li><a href="#"><i class="fa fa-user fa-fw"></i> 	${info.user.userNm}(${info.user.userId})</a></li>
	                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> 정보수정</a>
	                        <li class="divider"></li>
                        	<li><a href="/logout"><i class="fa fa-sign-out fa-fw"></i> 로그아웃</a>
	                    </sec:authorize>
	                    <sec:authorize access="!hasRole('ROLE_USR')">
					      <li><a href="#"><i class="fa fa-sign-out fa-fw"></i> 로그인</a>
					    </sec:authorize>
                    </ul>
                </li>
               <!-- /.dropdown-user -->
            </ul>

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
 
                        <li>
                            <a href="/admin/main"><i class="fa fa-dashboard fa-fw"></i> Dashboard<span class="fa arrow"></span></a>
                        </li>
                        <li>
                            <a href="/admin/board/list"><i class="fa fa-edit fa-fw"></i> 게시판<span class="fa arrow"></span></a>
                        </li>
                        <li>
                            <a href="/admin/board/list"><i class="fa fa-edit fa-fw"></i> 유틸<span class="fa arrow"></span></a>
                              <ul class="nav nav-second-level">
                                <li>
                                    <a href="/zTree/tree">zTree</a>
                                    <a href="/pageView/tree">jsTree</a>
                                    <a href="/static/zGrid/grid.html" target="_blank">zGrid</a>
                                    <a href="/admin/ui/form">UI Components</a>
                                    <a href="/admin/ui/form">FileUpload</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="/admin/socket/chat"><i class="fa fa-edit fa-fw"></i> Socket<span class="fa arrow"></span></a>
                              <ul class="nav nav-second-level">
                                <li>
                                    <a href="/admin/socket/chat">Chat</a>
                                </li>
                            </ul>
                        </li>
                                 <li>
                            <a href="/admin/elastic/info"><i class="fa fa-edit fa-fw"></i> ElasticSearch<span class="fa arrow"></span></a>
                              <ul class="nav nav-second-level">
                                <li>
                                    <a href="/admin/elastic/info">Info</a>
                                    <a href="/admin/elastic/createForm">Index / Type</a>
                                    <a href="/admin/elastic/searchList">Search</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 차트<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Line Charts</a>
                                </li>
                                <li>
                                    <a href="#"> Charts</a>
                                </li>
                            </ul>
                        </li>
                 
                    </ul>
                </div>
            </div>
        </nav>
        

        <!-- Page Content -->
		<div id="page-wrapper">
            <div class="container-fluid">
                
				<tiles:insertAttribute name="body" />
               		 
        	</div>
    	</div>
	</div>

</body>
    

</html>
