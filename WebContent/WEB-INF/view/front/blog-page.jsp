<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Acin Blog</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- Custom icon font-->
    <link rel="stylesheet" href="css/fontastic.css">
    <!-- Google fonts - Open Sans-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <!-- Fancybox-->
    <link rel="stylesheet" href="vendor/@fancyapps/fancybox/jquery.fancybox.min.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="favicon.png">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
    <header class="header">
      <!-- Main Navbar-->
      <nav class="navbar navbar-expand-lg">
        <div class="search-area">
          <div class="search-area-inner d-flex align-items-center justify-content-center">
            <div class="close-btn"><i class="icon-close"></i></div>
            <div class="row d-flex justify-content-center">
              <div class="col-md-8">
                <form action="blog-search.html">
                  <div class="form-group">
                    <input type="search" name="search" id="search" placeholder="What are you looking for?">
                    <button type="submit" class="submit"><i class="icon-search-1"></i></button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="container">
          <!-- Navbar Brand -->
          <div class="navbar-header d-flex align-items-center justify-content-between">
            <!-- Navbar Brand --><a href="index-page" class="navbar-brand">Acin Blog</a>
            <!-- Toggle Button-->
            <button type="button" data-toggle="collapse" data-target="#navbarcollapse" aria-controls="navbarcollapse" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler"><span></span><span></span><span></span></button>
          </div>
          <!-- Navbar Menu -->
          <div id="navbarcollapse" class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item"><a href="index-page" class="nav-link">Home</a>
              </li>
              <li class="nav-item"><a href="blog-page?page=0" class="nav-link active">Blog</a>
              </li>
              <li class="nav-item"><a href="contact-page" class="nav-link">Contact</a>
              </li>
            </ul>
            <div class="navbar-text"><a href="#" class="search-btn"><i class="icon-search-1"></i></a></div>
          </div>
        </div>
      </nav>
    </header>
    <div class="container">
      <div class="row">
        <!-- Latest Posts -->
        <main class="posts-listing col-lg-8"> 
          <div class="container">
            <div class="row">
              <!-- post -->
              <div class="post col-xl-6">
                <div class="post-thumbnail"><a href="blog-post?id=${latestBlogs[0].id}"><img src="${latestBlogs[0].image}" alt="..." class="img-fluid"></a></div>
                <div class="post-details">
                  <div class="post-meta d-flex justify-content-between">
                    <div class="date meta-last">${latestBlogs[0].date}</div>
                    <div class="category"><a href="blog-category.html">${latestBlogs[0].category.name}</a></div>
                  </div><a href="blog-post">
                    <h3 class="h4">${latestBlogs[0].title}</h3></a>
                  <p class="text-muted">${latestBlogs[0].description}</p>
                  <footer class="post-footer d-flex align-items-center"><a href="blog-author?id=${latestBlogs[0].user.id}" class="author d-flex align-items-center flex-wrap">
                      <div class="avatar"><img src="${latestBlogs[0].user.image}" alt="..." class="img-fluid"></div>
                      <div class="title"><span>${latestBlogs[0].user.name}</span></div></a>
                    <div class="date"><i class="icon-clock"></i> ${latestBlogs[0].date}</div>
                    <div class="comments meta-last"><i class="icon-comment"></i>${latestBlogs[0].comments.size()}</div>
                  </footer>
                </div>
              </div>
              <!-- post             -->
              <div class="post col-xl-6">
                <div class="post-thumbnail"><a href="blog-post?id=${latestBlogs[1].id}"><img src="${latestBlogs[1].image}" alt="..." class="img-fluid"></a></div>
                <div class="post-details">
                  <div class="post-meta d-flex justify-content-between">
                    <div class="date meta-last">${latestBlogs[1].date}</div>
                    <div class="category"><a href="blog-category.html">${latestBlogs[1].category.name}</a></div>
                  </div><a href="blog-post">
                    <h3 class="h4">${latestBlogs[1].title}</h3></a>
                  <p class="text-muted">${latestBlogs[1].description}</p>
                  <footer class="post-footer d-flex align-items-center"><a href="blog-author?id=${latestBlogs[1].user.id}" class="author d-flex align-items-center flex-wrap">
                      <div class="avatar"><img src="${latestBlogs[1].user.image}" alt="..." class="img-fluid"></div>
                      <div class="title"><span>${latestBlogs[1].user.name}</span></div></a>
                    <div class="date"><i class="icon-clock"></i> ${latestBlogs[1].date}</div>
                    <div class="comments meta-last"><i class="icon-comment"></i>${latestBlogs[1].comments.size()}</div>
                  </footer>
                </div>
              </div>
              <!-- post             -->
              <div class="post col-xl-6">
                <div class="post-thumbnail"><a href="blog-post?id=${latestBlogs[2].id}"><img src="${latestBlogs[2].image}" alt="..." class="img-fluid"></a></div>
                <div class="post-details">
                  <div class="post-meta d-flex justify-content-between">
                    <div class="date meta-last">${latestBlogs[2].date}</div>
                    <div class="category"><a href="blog-category.html">${latestBlogs[2].category.name}</a></div>
                  </div><a href="blog-post">
                    <h3 class="h4">${latestBlogs[2].title}</h3></a>
                  <p class="text-muted">${latestBlogs[2].description}</p>
                  <footer class="post-footer d-flex align-items-center"><a href="blog-author?id=${latestBlogs[2].user.id}" class="author d-flex align-items-center flex-wrap">
                      <div class="avatar"><img src="${latestBlogs[2].user.image}" alt="..." class="img-fluid"></div>
                      <div class="title"><span>${latestBlogs[2].user.name}</span></div></a>
                    <div class="date"><i class="icon-clock"></i> ${latestBlogs[2].date}</div>
                    <div class="comments meta-last"><i class="icon-comment"></i>${latestBlogs[2].comments.size()}</div>
                  </footer>
                </div>
              </div>
              <!-- post -->
              <div class="post col-xl-6">
                <div class="post-thumbnail"><a href="blog-post?id=${latestBlogs[3].id}"><img src="${latestBlogs[3].image}" alt="..." class="img-fluid"></a></div>
                <div class="post-details">
                  <div class="post-meta d-flex justify-content-between">
                    <div class="date meta-last">${latestBlogs[3].date}</div>
                    <div class="category"><a href="blog-category.html">${latestBlogs[3].category.name}</a></div>
                  </div><a href="blog-post">
                    <h3 class="h4">${latestBlogs[3].title}</h3></a>
                  <p class="text-muted">${latestBlogs[3].description}</p>
                  <footer class="post-footer d-flex align-items-center"><a href="blog-author?id=${latestBlogs[3].user.id}" class="author d-flex align-items-center flex-wrap">
                      <div class="avatar"><img src="${latestBlogs[3].user.image}" alt="..." class="img-fluid"></div>
                      <div class="title"><span>${latestBlogs[3].user.name}</span></div></a>
                    <div class="date"><i class="icon-clock"></i> ${latestBlogs[3].date}</div>
                    <div class="comments meta-last"><i class="icon-comment"></i>${latestBlogs[3].comments.size()}</div>
                  </footer>
                </div>
              </div>
            </div>
            <!-- Pagination -->
            <nav aria-label="Page navigation example">
              <ul class="pagination pagination-template d-flex justify-content-center">
                <li class="page-item"><a href="blog-page?page=0" class="page-link active">1</a></li>
                <li class="page-item"><a href="blog-page?page=1" class="page-link">2</a></li>
                <li class="page-item"><a href="blog-page?page=2" class="page-link">3</a></li>
              </ul>
            </nav>
          </div>
        </main>
        <aside class="col-lg-4">
          <!-- Widget [Search Bar Widget]-->
          <div class="widget search">
            <header>
              <h3 class="h6">Search the blog</h3>
            </header>
            <form action="blog-search" class="search-form">
              <div class="form-group">
                <input name="searchTerm" type="search" placeholder="What are you looking for?">
                <button type="submit" class="submit"><i class="icon-search"></i></button>
              </div>
            </form>
          </div>
          <!-- Widget [Latest Posts Widget]        -->
         <div class="widget latest-posts">
            <header>
              <h3 class="h6">Latest Posts</h3>
            </header>
            <div class="blog-post?id=${mostViewedBlogs[0].id}"><a href="blog-post?id=${mostViewedBlogs[0].id}">
                <div class="item d-flex align-items-center">
                  <div class="image"><img src="${mostViewedBlogs[0].image}" alt="..." class="img-fluid"></div>
                  <div class="title"><strong>${mostViewedBlogs[0].title}</strong>
                    <div class="d-flex align-items-center">
                      <div class="views"><i class="icon-eye"></i> ${mostViewedBlogs[0].views}</div>
                      <div class="comments"><i class="icon-comment"></i>${mostViewedBlogs[0].comments.size()}</div>
                    </div>
                  </div>
                </div></a><a href="blog-post?id=${mostViewedBlogs[1].id}">
                <div class="item d-flex align-items-center">
                  <div class="image"><img src="${mostViewedBlogs[1].image}" alt="..." class="img-fluid"></div>
                  <div class="title"><strong>${mostViewedBlogs[1].title}</strong>
                    <div class="d-flex align-items-center">
                      <div class="views"><i class="icon-eye"></i> ${mostViewedBlogs[1].views}</div>
                      <div class="comments"><i class="icon-comment"></i>${mostViewedBlogs[1].comments.size()}</div>
                    </div>
                  </div>
                </div></a><a href="blog-post?id=${mostViewedBlogs[2].id}">
                <div class="item d-flex align-items-center">
                  <div class="image"><img src="${mostViewedBlogs[2].image}" alt="..." class="img-fluid"></div>
                  <div class="title"><strong>${mostViewedBlogs[2].title}</strong>
                    <div class="d-flex align-items-center">
                      <div class="views"><i class="icon-eye"></i> ${mostViewedBlogs[2].views}</div>
                      <div class="comments"><i class="icon-comment"></i>${mostViewedBlogs[2].comments.size()}</div>
                    </div>
                  </div>
                </div></a></div>
          </div>
          <!-- Widget [Categories Widget]-->
          <div class="widget categories">
            <header>
              <h3 class="h6">Categories</h3>
            </header>
            <div class="item d-flex justify-content-between"><a href="blog-category?id=${categories[0].id}">${categories[0].name}</a><span>12</span></div>
            <div class="item d-flex justify-content-between"><a href="blog-category?id=${categories[1].id}">${categories[1].name}</a><span>25</span></div>
            <div class="item d-flex justify-content-between"><a href="blog-category?id=${categories[2].id}">${categories[2].name}</a><span>8</span></div>
            <div class="item d-flex justify-content-between"><a href="blog-category?id=${categories[3].id}">${categories[3].name}</a><span>17</span></div>
            <div class="item d-flex justify-content-between"><a href="blog-category?id=${categories[4].id}">${categories[4].name}</a><span>25</span></div>
          </div>
          <!-- Widget [Tags Cloud Widget]-->
          <div class="widget tags">       
            <header>
              <h3 class="h6">Tags</h3>
            </header>
            <ul class="list-inline">
              <li class="list-inline-item"><a href="blog-tag?id=${tags[0].id}" class="tag">#${tags[0].name}</a></li>
              <li class="list-inline-item"><a href="blog-tag?id=${tags[1].id}" class="tag">#${tags[1].name}</a></li>
              <li class="list-inline-item"><a href="blog-tag?id=${tags[2].id}" class="tag">#${tags[2].name}</a></li>
              <li class="list-inline-item"><a href="blog-tag?id=${tags[3].id}" class="tag">#${tags[3].name}</a></li>
              <li class="list-inline-item"><a href="blog-tag?id=${tags[4].id}" class="tag">#${tags[4].name}</a></li>
            </ul>
          </div>
        </aside>
      </div>
    </div>
    <!-- Page Footer-->
    <footer class="main-footer">
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <div class="logo">
              <h6 class="text-white">Bootstrap Blog</h6>
            </div>
            <div class="contact-details">
              <p>53 Broadway, Broklyn, NY 11249</p>
              <p>Phone: (020) 123 456 789</p>
              <p>Email: <a href="mailto:info@company.com">Info@Company.com</a></p>
              <ul class="social-menu">
                <li class="list-inline-item"><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li class="list-inline-item"><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li class="list-inline-item"><a href="#"><i class="fa fa-instagram"></i></a></li>
                <li class="list-inline-item"><a href="#"><i class="fa fa-behance"></i></a></li>
                <li class="list-inline-item"><a href="#"><i class="fa fa-pinterest"></i></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md-4">
            <div class="menus d-flex">
              <ul class="list-unstyled">
                <li> <a href="index.html">Home</a></li>
                <li> <a href="blog.html">Blog</a></li>
                <li> <a href="contact.html">Contact</a></li>
                <li> <a href="#">Login</a></li>
              </ul>
              <ul class="list-unstyled">
                <li> <a href="blog-category.html">Growth</a></li>
                <li> <a href="blog-category.html">Local</a></li>
                <li> <a href="blog-category.html">Sales</a></li>
                <li> <a href="blog-category.html">Tips</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md-4">
            <div class="latest-posts"><a href="blog-post">
                <div class="post d-flex align-items-center">
                  <div class="image"><img src="img/small-thumbnail-1.jpg" alt="..." class="img-fluid"></div>
                  <div class="title"><strong>Hotels for all budgets</strong><span class="date last-meta">October 26, 2016</span></div>
                </div></a><a href="blog-post">
                <div class="post d-flex align-items-center">
                  <div class="image"><img src="img/small-thumbnail-2.jpg" alt="..." class="img-fluid"></div>
                  <div class="title"><strong>Great street atrs in London</strong><span class="date last-meta">October 26, 2016</span></div>
                </div></a><a href="blog-post">
                <div class="post d-flex align-items-center">
                  <div class="image"><img src="img/small-thumbnail-3.jpg" alt="..." class="img-fluid"></div>
                  <div class="title"><strong>Best coffee shops in Sydney</strong><span class="date last-meta">October 26, 2016</span></div>
                </div></a></div>
          </div>
        </div>
      </div>
      <div class="copyrights">
        <div class="container">
          <div class="row">
            <div class="col-md-6">
              <p>&copy; 2017. All rights reserved. Your great site.</p>
            </div>
            <div class="col-md-6 text-right">
              <p>Template By <a href="https://bootstrapious.com/p/bootstrap-carousel" class="text-white">Bootstrapious</a>
                <!-- Please do not remove the backlink to Bootstrap Temple unless you purchase an attribution-free license @ Bootstrap Temple or support us at http://bootstrapious.com/donate. It is part of the license conditions. Thanks for understanding :)                         -->
              </p>
            </div>
          </div>
        </div>
      </div>
    </footer>
    <!-- JavaScript files-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper.js/umd/popper.min.js"> </script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="vendor/@fancyapps/fancybox/jquery.fancybox.min.js"></script>
    <script src="js/front.js"></script>
  </body>
</html>
