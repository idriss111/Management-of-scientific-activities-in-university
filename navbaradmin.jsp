<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <nav id="sidebar" >
            <div class="sidebar-header">
                <a href="index_admin.jsp"><img class="main-logo" src="AdminFolder/img/logo/logo.png" alt="" /></a>
                <strong><a href="#"><img src="AdminFolder/img/logo/logosn.png" alt="" /></a></strong>
            </div>
            <div class="left-custom-menu-adp-wrap comment-scrollbar">
                <nav class="sidebar-nav left-sidebar-menu-pro">
                    <ul class="metismenu" id="menu1">
                        <li class="active">
                            <a class="has-arrow" href="#TOP">
								   <span class="educate-icon educate-home icon-wrap"></span>
								   <span class="mini-click-non">Education</span>
								</a>
                            <ul class="submenu-angle" aria-expanded="true">
                                <li><a title="Dashboard v.1" href="${pageContext.request.contextPath}/logout"><span class="mini-sub-pro">Logout </span></a></li>
                            </ul>
                        </li>
                        
                        <li>
                            <a class="has-arrow" href="all-professors.jsp" aria-expanded="false"><span class="educate-icon educate-professor icon-wrap"></span> <span class="mini-click-non">Professors</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="All Professors" href="${pageContext.request.contextPath}/listeChercheurs"><span class="mini-sub-pro">liste des chercheurs</span></a></li>
                                <li><a title="Add Professor" href="${pageContext.request.contextPath}/ajouterChercheur"><span class="mini-sub-pro">Ajouter un chercheur</span></a></li>
                                <li><a title="Edit Professor" href="${pageContext.request.contextPath}/modifierChercheur"><span class="mini-sub-pro">Modifier un chercheur</span></a></li>
                                <li><a title="Edit Professor" href="${pageContext.request.contextPath}/supprimerChercheur"><span class="mini-sub-pro">Supprimer un chercheur</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="has-arrow" href="all-students.jsp" aria-expanded="false"><span class="educate-icon educate-student icon-wrap"></span> <span class="mini-click-non">Equipe</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="All Students" href="${pageContext.request.contextPath}/ajouterEquipe"><span class="mini-sub-pro">Ajouter une equipe</span></a></li>
                                <li><a title="Add Students" href="${pageContext.request.contextPath}/modifierEquipe"><span class="mini-sub-pro">Modifier une equipe</span></a></li>
                                <li><a title="Edit Students" href="${pageContext.request.contextPath}/supprimerEquipe"><span class="mini-sub-pro">Supprimer une equipe</span></a></li>
                                 <li><a title="Edit Students" href="${pageContext.request.contextPath}/listeEquipes"><span class="mini-sub-pro">liste Equipes</span></a></li>
                                
                            </ul>
                        </li>
                        <li>
                            <a class="has-arrow" href="#" aria-expanded="false"><span class="educate-icon educate-course icon-wrap"></span> <span class="mini-click-non">Laboratoire</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="All Courses" href="${pageContext.request.contextPath}/ajouterLaboratoire"><span class="mini-sub-pro">Ajouter Laboratoire</span></a></li>
                                <li><a title="Add Courses" href="${pageContext.request.contextPath}/supprimerLaboratoire"><span class="mini-sub-pro">supprimer Laboratoire</span></a></li>
                                <li><a title="Edit Courses" href="${pageContext.request.contextPath}/listeLaboratoires"><span class="mini-sub-pro">liste Laboratoires</span></a></li>
                            </ul>
                        </li>
                        
                    </ul>
                </nav>
            </div>
        </nav>