<!-- head -->

<%@ include file="../partials/head.jsp" %>

<!-- navbar -->

<%@ include file="../partials/navbar.jsp" %>

<!-- sidebar -->

<%@ include file="../partials/sidebar.jsp" %>


<div>
    <!-- AQUI VA EL CONTENIDO -->


    <div class="mascota-profile-bg-img">

    </div>


    <div id="content-page" class="content-page superponer">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="text-center" style="background-color: #B5D4DD;padding-bottom: 20px;">
                                <img src="${pageContext.request.contextPath}/images/page-img/404.gif" width="200px" alt="">
                                <h4 class="w-100 text-center" style="color: #212520!important;">${error}</h4>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>





</div>




<!-- footer -->

<%@ include file="../partials/footer.jsp" %>

<!-- scripts -->

<%@ include file="../partials/script.jsp" %>


