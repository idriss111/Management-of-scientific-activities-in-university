<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Espace d'encadrement</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

     <style>
      #button{
        display: inline-block;
        background-color: #3898d8;
        border-radius: 10px;
        border: 2px double #cccccc;
        color: #eeeeee;
        text-align: center;
        font-size: 22px;
        padding: 15px;
        width: 190px;
        transition: all 0.5s;
        cursor: pointer;
        margin: 4px;
        
      }
      #button span {
        cursor: pointer;
        display: inline-block;
        position: relative;
        transition: 0.5s;
      }
      #button span:after {
        content: "\00bb";
        position: absolute;
        opacity: 0;
        top: 0;
        right: -20px;
        transition: 0.5s;
      }
      #button:hover {
        background-color: #6abdcc;
      }
      #button:hover span {
        padding-right: 25px;
      }
      #button:hover span:after {
        opacity: 1;
        right: 0;
      }
     /*! HTML5 Boilerplate v5.0 | MIT License | http://h5bp.com/ */
html,
body,
div,
span,
applet,
object,
iframe,
h1,
h2,
h3,
h4,
h5,
h6,
p,
blockquote,
pre,
a,
abbr,
acronym,
address,
big,
cite,
code,
del,
dfn,
em,
img,
ins,
kbd,
q,
s,
samp,
small,
strike,
strong,
sub,
sup,
tt,
var,
b,
u,
i,
center,
dl,
dt,
dd,
ol,
ul,
li,
fieldset,
form,
label,
legend,
table,
caption,
tbody,
tfoot,
thead,
tr,
th,
td,
article,
aside,
canvas,
details,
embed,
figure,
figcaption,
footer,
header,
hgroup,
menu,
nav,
output,
ruby,
section,
summary,
time,
mark,
audio,
video {
  margin: 0;
  padding: 0;
  border: 0;
  font-size: 100%;
}

@import url(https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700);

html {
  color: #222;
  font-family: "Sourse Sans Pro", sans-serif;
  font-size: 14px;
  line-height: 1.4;
}

::-moz-selection {
  background: #b3d4fc;
  text-shadow: none;
}

::selection {
  background: #b3d4fc;
  text-shadow: none;
}

hr {
  display: block;
  height: 1px;
  border: 0;
  border-top: 1px solid #ccc;
  margin: 1em 0;
  padding: 0;
}

audio,
canvas,
iframe,
img,
svg,
video {
  vertical-align: middle;
}

fieldset {
  border: 0;
  margin: 0;
  padding: 0;
}

textarea {
  resize: vertical;
}

.browserupgrade {
  margin: 0.2em 0;
  background: #ccc;
  color: #000;
  padding: 0.2em 0;
}

/* ==========================================================================
   Author's custom styles
   ========================================================================== */

a {
  color: #0288d1;
  text-decoration: none;
}

a:hover {
  color: #ffff00;
}

h2 {
  margin-top: 25px;
  font-size: 25px;
}

.title {
  margin-top: 10px;
}

p {
  padding-top: 4px;
}

ul,
ol {
  margin: 0;
  padding: 0;
  list-style-type: none;
}

.container {
  margin: 0 auto;
  width: 80%;
  overflow: hidden;
}

#main-header {
  height: 100px;
  border-bottom: 2px #0288d1 solid;
  overflow: hidden;
  margin-bottom: 20px;
}

#branding {
  float: left;
  width: 50%;
}

#branding h1 {
  color: #fff;
  padding: 0 0 0 70px;
}

#branding img {
  position: absolute;
  height: auto;
}

#main-nav {
  float: right;
  width: 50%;
  padding-top: 12px;
}

#main-nav li {
  float: left;
  padding: 8% 5% 0 5%;
  font-size: 14px;
  font-weight: 700;
  display: inline-block;
  text-transform: uppercase;
}

#content {
  float: left;
  width: 63%;
  margin-right: 7%;
}

#sidebar {
  float: right;
  width: 30%;
  margin-top: 12%;
}

article h2 {
  margin-top: 10%;
  padding: 5px 10px;
  background: #333;
  color: #fff;
}

article img {
  width: 100%;
}

article .meta {
  margin: 0;
  padding: 5px 10px;
}

article .meta span {
  float: right;
}

article .readmore {
  background-color: #0288d1;
  color: #fff;
  margin: 0;
  padding: 5px 0;
  text-align: center;
  font-weight: bold;
}

article .readmore:hover {
  background-color: #ffff00;
}

#sub-nav {
  padding: 20px 0 20px 0;
}

#sub-nav li {
  font-size: 13px;
  font-weight: bold;
  padding: 5px 0 5px 0;
  border-bottom: 1px dotted #0288d1;
}

.ad img {
  width: 100%;
}

#main-footer {
  background: #0288d1;
  color: #fff;
  min-height: 150px;
  padding-top: 20px;
  margin-top: 35px;
  overflow: auto;
}

#main-footer a {
  color: #fff;
  font-size: 13px;
}

#main-footer .footer-nav li {
  padding: 3px 0 7px;
}

#main-footer .copy {
  margin: 0;
  font-size: 13px;
}

.push {
  clear: both;
  height: 18em;
}

/*code below doesn't work*/

.search input [type="search"] {
  border: 1px solid #ccc;
  height: 15px;
  width: 85%;
  padding: 3px;
  float: left;
}

.search input [type="search"] {
  width: 10%;
  float: right;
}
/* end of not working css*/

#comments {
  margin-top: 45px;
}

.comment-left {
  float: left;
  width: 8%;
}

.comment-left img {
  width: 100%;
}

.comment-right {
  float: right;
  width: 85%;
}

.contact-form {
  margin-top: 20px;
  padding: 5px 20px 10px 20px;
  border-radius: 2px;
}

.contact-form #button {
  padding: 7px 10px;
}

.contact-form input [type="text"],
.contact-form input [type="email"] {
  border: 1px solid #ccc;
  height: 20px;
  padding: 3px;
  width: 97%;
}

.contact-form textarea {
  border: 1px solid #ccc;
  border-radius: 2px;
  padding: 10px;
  width: 97%;
}

.add-form input [type="text"] {
  border: 1px solid #ccc;
  height: 20px;
  padding: 3px;
  width: 97%;
}

.add-form #button {
  padding: 7px 10px;
}

.add-form select {
  border: 1px solid #0288d1;
  height: 33px;
  padding: 3px;
  width: 98%;
}

.add-form textarea {
  border: 1px solid #0288d1;
  height: 50px;
  padding: 10px;
  width: 94%;
}

/* ==========================================================================
   Media Queries
   ========================================================================== */

@media only screen and (max-width: 900px) {
  #main-nav {
    width: 80%;
  }

  #sidebar {
    float: none;
    width: 100%;
  }

  #content {
    float: none;
    width: 100%;
  }
}

@media print,
  (-o-min-device-pixel-ratio: 5/4),
  (-webkit-min-device-pixel-ratio: 1.25),
  (min-resolution: 120dpi) {
}

/* ==========================================================================
   Helper classes
   ========================================================================== */

.hidden {
  display: none !important;
  visibility: hidden;
}

.visuallyhidden {
  border: 0;
  clip: rect(0 0 0 0);
  height: 1px;
  margin: -1px;
  overflow: hidden;
  padding: 0;
  position: absolute;
  width: 1px;
}

.visuallyhidden.focusable:active,
.visuallyhidden.focusable:focus {
  clip: auto;
  height: auto;
  margin: 0;
  overflow: visible;
  position: static;
  width: auto;
}

.invisible {
  visibility: hidden;
}

.clearfix:before,
.clearfix:after {
  content: " ";
  display: table;
}

.clearfix:after {
  clear: both;
}

.clearfix {
  *zoom: 1;
}

/* ==========================================================================
   Print styles
   ========================================================================== */

@media print {
  *,
  *:before,
  *:after {
    background: transparent !important;
    color: #000 !important;
    box-shadow: none !important;
    text-shadow: none !important;
  }

  a,
  a:visited {
    text-decoration: underline;
  }

  a[href]:after {
    content: " (" attr(href) ")";
  }

  abbr[title]:after {
    content: " (" attr(title) ")";
  }

  a[href^="#"]:after,
  a[href^="javascript:"]:after {
    content: "";
  }

  pre,
  blockquote {
    border: 1px solid #999;
    page-break-inside: avoid;
  }

  thead {
    display: table-header-group;
  }

  tr,
  img {
    page-break-inside: avoid;
  }

  img {
    max-width: 100% !important;
  }

  p,
  h2,
  h3 {
    orphans: 3;
    widows: 3;
  }

  h2,
  h3 {
    page-break-after: avoid;
  }
}
     </style>

    </head>
    <body>
        <header id="main-header">
            <div class="container">
                <div id="branding">
                    <a href="index.html"><img src="http://annakozlova.com/img/logo-blog.png" alt="The Blog"></a>
                    <!--<h1>The Blog</h1>-->
                </div><!-- Branding -->
                <nav id="main-nav">
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/Projets">Home</a></li>
                        <li><a href="#">Single Post</a></li>
                        <li><a href="${pageContext.request.contextPath}/ajouterProjet">Ajouter un projet de recherche</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        
        <div class="container">
            <div id="sidebar">
                <div class="search">
                    <form action="soutenance">
                        <input type="search" placeholder="Search for blog posts"><input type="image" src="http://annakozlova.com/img/search-mod.png" alt="Search">
                    </form>
                </div><!-- Search-->
                <div class="clearfix"></div>
                <nav id="sub-nav">
                    <ul>
                        <li><a href="#">Mathematics</a></li>
                        <li><a href="#">Biology</a></li>
                        <li><a href="#">Computer Science</a></li>
                        <li><a href="#">Chemistry</a></li>
                        <li><a href="#">Medicine</a></li>
                        <li><a href="#">Physics</a></li>
                        <li><a href="#">Astrophysics</a></li>
                    </ul>
                </nav>
                 
            </div><!-- Side bar -->
            
            <section id="content">
                <div class="add-form">
                    <h2>Fixez la soutenance</h2>
                    <form action="soutenance" method="post"  enctype='multipart/form-data'>
                        <p>
                          <label><p class="title">Intitulé :</p> </label>
                            <input type="text"  name="intitule" required>
                        </p>
                         <p>
                            <label>Lieu de soutenance : </label>
                            <br>
                            <select name="lieu" required>
                            <option value="faculté de sciences ">FS</option>
                            <option value="faculté de lettres et sciences humaines">FSLH</option>
                            <option value="faculté de sciences juridiques et sociales">FSJES</option>
                            <option value="ENSAM">ENSAM</option>
                            <option value="ENCG">ENCG</option>
                            <option value="ESTM">ESTM</option>
                            </select>
                        </p>
                        
                        <p>
                           
                          <label><p>Date de soutenance :</p></label>
                            <br>
                            <input type="date" name="dateSout" required>
                        </p>
                        <p>
                            <label>Justificatif : </label>
                            <input type="file" name="justificatif" accept=".jpg, .jpeg, .png, .pdf" > 
                        </p>
                        
                        <br>
                        <p>
                            <input type="submit" value="Terminer" id="button" href=""></input>
                        </p>
                    </form>
                </div><!-- add form -->
                <div class="push"></div>
            </section>
            <div class="clearfix"></div>
        </div><!-- Container -->
        <footer id="main-footer">
            <div class="container">
                <div class="footer-column">
                    <nav class="footer-nav">
                        <ul>
                            <li><a href="#" class="active">Home</a></li>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Contact US</a></li>
                            <li><a href="#">Terms of Use</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                        </ul>
                    </nav>
                    <nav class="footer-nav copy"><p>Copyright &copy; 2015, The Blog</p></nav>
                </div>
            </div>
        </footer>
    </body>
</html>
