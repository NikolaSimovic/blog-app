<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


    
    <!-- owl carousel 2 stylesheet-->
    <link rel="stylesheet" href="plugins/owl-carousel2/assets/owl.carousel.min.css" id="theme-stylesheet">
    <link rel="stylesheet" href="plugins/owl-carousel2/assets/owl.theme.default.min.css" id="theme-stylesheet">
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
              <li class="nav-item"><a href="index-page" class="nav-link active">Home</a>
              </li>
              <li class="nav-item"><a href="blog-page?page=0" class="nav-link">Blog</a>
              </li>
              <li class="nav-item"><a href="contact-page" class="nav-link">Contact</a>
              </li>
            </ul>
            <div class="navbar-text"><a href="#" class="search-btn"><i class="icon-search-1"></i></a></div>
          </div>
        </div>
      </nav>
    </header>

    <!-- Hero Section-->
    <div id="index-slider" class="owl-carousel">
      <section style="background: url(${slideList[0].image}); background-size: cover; background-position: center center" class="hero">
        <div class="container">
          <div class="row">
            <div class="col-lg-7">
              <h1>${slideList[0].title}</h1>
              <a href="${slideList[0].buttonUrl}" class="hero-link">${slideList[0].buttonName}</a>
            </div>
          </div>
        </div>
      </section>
     <section style="background: url(${slideList[1].image}); background-size: cover; background-position: center center" class="hero">
        <div class="container">
          <div class="row">
            <div class="col-lg-7">
              <h1>${slideList[1].title}</h1>
              <a href="${slideList[1].buttonUrl}" class="hero-link">${slideList[1].buttonName}</a>
            </div>
          </div>
        </div>
      </section>
      <section style="background: url(img/featured-pic-3.jpeg); background-size: cover; background-position: center center" class="hero">
        <div class="container">
          <div class="row">
            <div class="col-lg-7">
              <h1>This is third slide, there will be more!</h1>
              <a href="blog-tag.html" class="hero-link">Findout More</a>
            </div>
          </div>
        </div>
      </section>
    </div>

    <section class="featured-posts no-padding-top">
      <div class="container">
        <!-- Post-->
        <div class="row d-flex align-items-stretch">
          <div class="text col-lg-7">
            <div class="text-inner d-flex align-items-center">
              <div class="content">
                <header class="post-header">
                  <div class="category"><a href="blog-category.html">${importantBlogs[0].category.name}</a></div><a href="blog-post?id=${importantBlogs[0].id}"">
                    <h2 class="h4">${importantBlogs[0].title}</h2></a>
                </header>
                <p>${importantBlogs[0].description}</p>
                <footer class="post-footer d-flex align-items-center"><a href="blog-author?id=${importantBlogs[0].user.id}" class="author d-flex align-items-center flex-wrap">
                    <div class="avatar"><img src="${importantBlogs[0].user.image}" alt="..." class="img-fluid"></div>
                    <div class="title"><span>${importantBlogs[0].user.name}</span></div></a>
                  <div class="date"><i class="icon-clock"></i>${importantBlogs[0].date}</div>
                  <div class="comments"><i class="icon-comment"></i>${importantBlogs[0].comments.size()}</div>
                </footer>
              </div>
            </div>
          </div>
          <div class="image col-lg-5"><img src="${importantBlogs[0].image}" alt="..."></div>
        </div>
        <!-- Post        -->
        <div class="row d-flex align-items-stretch">
          <div class="image col-lg-5"><img src="${importantBlogs[1].image}" alt="..."></div>
          <div class="text col-lg-7">
            <div class="text-inner d-flex align-items-center">
              <div class="content">
                <header class="post-header">
                  <div class="category"><a href="blog-category.html">${importantBlogs[1].category.name}</a></div><a href="blog-post?id=${importantBlogs[1].id}"">
                    <h2 class="h4">${importantBlogs[1].title}</h2></a>
                </header>
                <p>${importantBlogs[1].description}</p>
                <footer class="post-footer d-flex align-items-center"><a href="blog-author?id=${importantBlogs[0].user.id}" class="author d-flex align-items-center flex-wrap">
                    <div class="avatar"><img src="${importantBlogs[1].user.image}" alt="..." class="img-fluid"></div>
                    <div class="title"><span>${importantBlogs[1].user.name}</span></div></a>
                  <div class="date"><i class="icon-clock"></i>${importantBlogs[1].date}</div>
                  <div class="comments"><i class="icon-comment"></i>${importantBlogs[1].comments.size()}</div>
                </footer>
              </div>
            </div>
          </div>
        </div>
        <!-- Post                            -->
         <div class="row d-flex align-items-stretch">
          <div class="text col-lg-7">
            <div class="text-inner d-flex align-items-center">
              <div class="content">
                <header class="post-header">
                  <div class="category"><a href="blog-category.html">${importantBlogs[2].category.name}</a></div><a href="blog-post?id=${importantBlogs[2].id}"">
                    <h2 class="h4">${importantBlogs[2].title}</h2></a>
                </header>
                <p>${importantBlogs[2].description}</p>
                <footer class="post-footer d-flex align-items-center"><a href="blog-author?id=${importantBlogs[2].user.id}" class="author d-flex align-items-center flex-wrap">
                    <div class="avatar"><img src="${importantBlogs[2].user.image}" alt="..." class="img-fluid"></div>
                    <div class="title"><span>${importantBlogs[2].user.name}</span></div></a>
                  <div class="date"><i class="icon-clock"></i>${importantBlogs[2].date}</div>
                  <div class="comments"><i class="icon-comment"></i>${importantBlogs[2].comments.size()}</div>
                </footer>
              </div>
            </div>
          </div>
          <div class="image col-lg-5"><img src="${importantBlogs[2].image}" alt="..."></div>
        </div>
      </div>
    </section>
    <!-- Divider Section-->
    <section style="background: url(img/divider-bg.jpg); background-size: cover; background-position: center bottom" class="divider">
      <div class="container">
        <div class="row">
          <div class="col-md-7">
            <h2>Any questions?</h2>
            <a href="contact-page" class="hero-link">Contact Us</a>
          </div>
        </div>
      </div>
    </section>
    <!-- Latest Posts -->
    <section class="latest-posts"> 
      <div class="container">
        <header> 
          <h2>Latest from the blog</h2>
        </header>
        <div class="owl-carousel" id="latest-posts-slider">
          <div class="row">
            <div class="post col-md-4">
              <div class="post-thumbnail"><a href="blog-post?id=${latestBlogs[0].id}""><img src="${latestBlogs[0].image}" alt="..." class="img-fluid"></a></div>
              <div class="post-details">
                <div class="post-meta d-flex justify-content-between">
                  <div class="date">${latestBlogs[0].date}</div>
                  <div class="category"><a href="blog-category.html">${latestBlogs[0].category.name}</a></div>
                </div><a href="blog-post?id=${latestBlogs[0].id}"">
                  <h3 class="h4">${latestBlogs[0].title}</h3></a>
                <p class="text-muted">${latestBlogs[0].description}</p>
              </div>
            </div>
            <div class="post col-md-4">
              <div class="post-thumbnail"><a href="blog-post?id=${latestBlogs[1].id}""><img src="${latestBlogs[1].image}" alt="..." class="img-fluid"></a></div>
              <div class="post-details">
                <div class="post-meta d-flex justify-content-between">
                  <div class="date">${latestBlogs[1].date}</div>
                  <div class="category"><a href="blog-category.html">${latestBlogs[1].category.name}</a></div>
                </div><a href="blog-post?id=${latestBlogs[1].id}"">
                  <h3 class="h4">${latestBlogs[1].title}</h3></a>
                <p class="text-muted">${latestBlogs[1].description}</p>
              </div>
            </div>
            <div class="post col-md-4">
              <div class="post-thumbnail"><a href="blog-post?id=${latestBlogs[2].id}""><img src="${latestBlogs[2].image}" alt="..." class="img-fluid"></a></div>
              <div class="post-details">
                <div class="post-meta d-flex justify-content-between">
                  <div class="date">${latestBlogs[2].date}</div>
                  <div class="category"><a href="blog-category.html">${latestBlogs[2].category.name}</a></div>
                </div><a href="blog-post?id=${latestBlogs[2].id}"">
                  <h3 class="h4">${latestBlogs[2].title}</h3></a>
                <p class="text-muted">${latestBlogs[2].description}</p>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="post col-md-4">
              <div class="post-thumbnail"><a href="blog-post?id=${latestBlogs[3].id}""><img src="${latestBlogs[3].image}" alt="..." class="img-fluid"></a></div>
              <div class="post-details">
                <div class="post-meta d-flex justify-content-between">
                  <div class="date">${latestBlogs[3].date}</div>
                  <div class="category"><a href="blog-category.html">${latestBlogs[3].category.name}</a></div>
                </div><a href="blog-post?id=${latestBlogs[3].id}"">
                  <h3 class="h4">${latestBlogs[3].title}</h3></a>
                <p class="text-muted">${latestBlogs[3].description}</p>
              </div>
            </div>
            <div class="post col-md-4">
              <div class="post-thumbnail"><a href="blog-post?id=${latestBlogs[4].id}""><img src="${latestBlogs[4].image}" alt="..." class="img-fluid"></a></div>
              <div class="post-details">
                <div class="post-meta d-flex justify-content-between">
                  <div class="date">${latestBlogs[4].date}</div>
                  <div class="category"><a href="blog-category.html">${latestBlogs[4].category.name}</a></div>
                </div><a href="blog-post?id=${latestBlogs[4].id}"">
                  <h3 class="h4">${latestBlogs[4].title}</h3></a>
                <p class="text-muted">${latestBlogs[4].description}</p>
              </div>
            </div>
           <div class="post col-md-4">
              <div class="post-thumbnail"><a href="blog-post?id=${latestBlogs[5].id}""><img src="${latestBlogs[5].image}" alt="..." class="img-fluid"></a></div>
              <div class="post-details">
                <div class="post-meta d-flex justify-content-between">
                  <div class="date">${latestBlogs[5].date}</div>
                  <div class="category"><a href="blog-category.html">${latestBlogs[5].category.name}</a></div>
                </div><a href="blog-post?id=${latestBlogs[5].id}"">
                  <h3 class="h4">${latestBlogs[5].title}</h3></a>
                <p class="text-muted">${latestBlogs[5].description}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Gallery Section-->
    <section class="gallery no-padding">    
      <div class="row">
        <div class="mix col-lg-3 col-md-3 col-sm-6">
          <div class="item">
            <a href="img/gallery-1.jpg" data-fancybox="gallery" class="image">
              <img src="img/gallery-1.jpg" alt="gallery image alt 1" class="img-fluid" title="gallery image title 1">
              <div class="overlay d-flex align-items-center justify-content-center"><i class="icon-search"></i></div>
            </a>
          </div>
        </div>
        <div class="mix col-lg-3 col-md-3 col-sm-6">
          <div class="item">
            <a href="img/gallery-2.jpg" data-fancybox="gallery" class="image">
              <img src="img/gallery-2.jpg" alt="gallery image alt 2" class="img-fluid" title="gallery image title 2">
              <div class="overlay d-flex align-items-center justify-content-center"><i class="icon-search"></i></div>
            </a>
          </div>
        </div>
        <div class="mix col-lg-3 col-md-3 col-sm-6">
          <div class="item">
            <a href="img/gallery-3.jpg" data-fancybox="gallery" class="image">
              <img src="img/gallery-3.jpg" alt="gallery image alt 3" class="img-fluid" title="gallery image title 3">
              <div class="overlay d-flex align-items-center justify-content-center"><i class="icon-search"></i></div>
            </a>
          </div>
        </div>
        <div class="mix col-lg-3 col-md-3 col-sm-6">
          <div class="item">
            <a href="img/gallery-4.jpg" data-fancybox="gallery" class="image">
              <img src="img/gallery-4.jpg" alt="gallery image alt 4" class="img-fluid" title="gallery image title 4">
              <div class="overlay d-flex align-items-center justify-content-center"><i class="icon-search"></i></div>
            </a>
          </div>
        </div>
        
      </div>
    </section>
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
            <div class="latest-posts"><a href="blog-post.html">
                <div class="post d-flex align-items-center">
                  <div class="image"><img src="img/small-thumbnail-1.jpg" alt="..." class="img-fluid"></div>
                  <div class="title"><strong>Hotels for all budgets</strong><span class="date last-meta">October 26, 2016</span></div>
                </div></a><a href="blog-post.html">
                <div class="post d-flex align-items-center">
                  <div class="image"><img src="img/small-thumbnail-2.jpg" alt="..." class="img-fluid"></div>
                  <div class="title"><strong>Great street atrs in London</strong><span class="date last-meta">October 26, 2016</span></div>
                </div></a><a href="blog-post.html">
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


    <script src="plugins/owl-carousel2/owl.carousel.min.js"></script>
    <script>
      $("#index-slider").owlCarousel({
        "items": 1,
        "loop": true,
        "autoplay": true,
        "autoplayHoverPause": true
      });

      $("#latest-posts-slider").owlCarousel({
        "items": 1,
        "loop": true,
        "autoplay": true,
        "autoplayHoverPause": true
      });
    </script>
    
  </body>
</html>