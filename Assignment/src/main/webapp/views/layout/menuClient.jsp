<div class="container">
  <div class="row">
    <nav class="navbar navbar-expand-lg ">
      <div class="container-fluid header_dow">
        <div class="col-6">
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a
                  class="nav-link me-3 menu-detail"
                  aria-current="page"
                  href="/Assignment/client/home/hien-thi"
                  >Home</a
                >
              </li>
              <li class="nav-item">
                <a class="nav-link me-3 menu-detail" href="/Assignment/client/about/hien-thi"
                  >About</a
                >
              </li>
              <li class="nav-item">
                <a class="nav-link me-3 menu-detail" href="/Assignment/client/san-pham/hien-thi"
                  >Product</a
                >
              </li>
            </ul>
          </div>
        </div>
        <div class="col-5">
          <form class="d-flex" role="search" method="get">
            <input
              class="form-control me-2"
              type="search"
              placeholder="Search"
              aria-label="Search"
              name="search"
            />
            <button
              class="btn btn-outline-warning"
              type="submit"
              formaction="/Assignment/client/search"
            >
              <i class="fa-solid fa-magnifying-glass"></i>
            </button>
          </form>
        </div>
        <div class="col-1 text-end">
          <a href="/Assignment/client/gio-hang/hien-thi">
            <i class="fa-solid fa-bag-shopping icon-giohang"></i>
            <span
              class="position-absolute start-100 translate-middle badge rounded-pill bg-danger"
            >
            ${ slGioHang }
              
              <span class="visually-hidden">unread messages</span>
            </span>
          </a>
        </div>
      </div>
    </nav>
  </div>
</div>