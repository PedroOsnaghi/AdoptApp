<div class="card">
    <div class="card-body profile-page p-0">
        <div class="profile-header">
            <div class="position-relative">
                <img src="${pageContext.request.contextPath}/images/page-img/user-bg.avif" alt="profile-bg"
                     class="rounded img-fluid portrait-profile" loading="lazy">

            </div>
            <div class="user-detail text-center mb-3">
                <div class="profile-img">
                    <img src="${pageContext.request.contextPath}/images/user/${user.imagen}" alt="profile-img" loading="lazy"
                         class="avatar-130 img-fluid"/>
                </div>
                <div class="profile-detail">
                    <h3 class="">${user.nombre}</h3>
                </div>
            </div>
            <div
                    class="profile-info p-3 d-flex align-items-center justify-content-end position-relative">

                <div class="social-info">
                    <ul
                            class="social-data-block d-flex align-items-center justify-content-between list-inline p-0 m-0">
                        <li class="text-center ps-3">
                            <h6>Publicados</h6>
                            <p class="mb-0">4</p>
                        </li>
                        <li class="text-center ps-3">
                            <h6>Adoptados</h6>
                            <p class="mb-0">2</p>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>