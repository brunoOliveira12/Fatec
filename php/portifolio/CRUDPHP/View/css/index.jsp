<%-- 
    Document   : index
    Created on : 20/06/2018, 13:01:52
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <title>Empresa</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">
        <script src="js/ie-emulation-modes-warning.js"></script>

    </head>

    <body>  
        <%@ include file="menu.jsp" %>
        <!-- Carousel
         ================================================== -->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide" src="image/1.png" alt="First slide">
                    <div class="container">
                        <!--<div class="carousel-caption">
                           <h1>Example headline.</h1>
                           <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
                           <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
                         </div>-->
                    </div>
                </div>
                <div class="item">
                    <img class="second-slide" src="image/2.jpg" alt="Second slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Another example headline.</h1>
                            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>                            
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="third-slide" src="image/3.jpg" alt="Third slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>One more for good measure.</h1>
                            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>                            
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div><!-- /.carousel -->

        <!-- Inicio da historia da empresa -->

        <div class="container marketing">

            <!-- Three columns of text below the carousel -->
            <!--<div class="row">
              <div class="col-lg-4">
                <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                <h2>Funcionário 1</h2>
                <p>Descrição do funcionário</p>
              </div>
              <div class="col-lg-4">
                <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                <h2>Funcionário 2</h2>
                <p>Descrição do funcionário</p>
              </div>
              <div class="col-lg-4">
                <img class="img-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
                <h2>Funcionário 3</h2>
                <p>Descrição do funcionário</p>
            <!-- <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
          </div>
        </div>-->

            <!-- START THE FEATURETTES -->

            <!-- pular linhas <hr class="featurette-divider">-->

            <div class="row featurette">
                <div class="col-md-7">
                    <h2 class="featurette-heading">História da Empresa : <span class="text-muted">Blabkabla</span></h2>
                    <p class="lead">A empresa foi criada em...</p>
                </div>
                <div class="col-md-5">
                    <img class="featurette-image img-responsive center-block" src="image/empresa1.jpg" alt="Generic placeholder image">
                </div>
            </div>

            <div class="row featurette">
                <div class="col-md-7 col-md-push-5">
                    <h2 class="featurette-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
                    <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
                </div>
                <div class="col-md-5 col-md-pull-7">
                    <img class="featurette-image img-responsive center-block" src="image/empresa2.jpg" alt="Generic placeholder image">
                </div>
            </div>

            <div class="row featurette">
                <div class="col-md-7">
                    <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
                    <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
                </div>
                <div class="col-md-5">
                    <img class="featurette-image img-responsive center-block" src="image/500.png" alt="Generic placeholder image">
                </div>
            </div>
            <!-- /END THE FEATURETTES -->
        </div><!-- container -->

        <!-- FOOTER -->
        <footer class="container footer">
            <div class="row">
                <h3>Mapa de Site</h3>
                <div class="col-xs-2">Home<br>Colunas</div>
                <div class="col-xs-2">Serviços<br>Colunas</div>
                <div class="col-xs-2">Contatos<br>Colunas</div>
                <div class="col-xs-2">Administrador<br>Colunas</div>
            </div>
        </footer>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery.min.js"><\/script>')</script>
        <script src="js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="js/ie10-viewport-bug-workaround.js"></script>
        <!-- para carousel -->
        <script src="js/vendor/holder.min.js"></script>
    </body>
</html>
