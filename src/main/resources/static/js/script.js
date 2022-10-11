
$(function () {
    $(".btn_top").click(function(){
        $('.wrap').stop().animate({scrollTop:0},300);
        console.log("scrollTop", scrollTop);
    });

    // media 1023px 이하 gnb
    const m = window.matchMedia("screen and (max-width: 1023px)");

    m.addEventListener("change", () => {
        if (m.matches) {
            console.log("mobile")
            $(".gnb > ul").css("display", "none");
            //$(".gnb_depthWrap").show();
            $(".btn_gnb").removeClass('on');
            $('header').removeClass('on');
            $(".gnb > ul > li").unbind("mouseover");
        } else {
            console.log("web")
            $(".gnb > ul").css("display", "flex");
            $(this).find(".gnb_depthWrap").hide();

            $(".gnb > ul > li").bind("mouseover", function () {
                $(".gnb_depthWrap").hide()
                $(this).find(".gnb_depthWrap").show();
            });
        }
    })

    // gnb 키보드 접근
    if (!m.matches) {
        //web
        $(".gnb > ul > li").bind("mouseover", function () {
            $(".gnb_depthWrap").hide();
            $(this).find(".gnb_depthWrap").show();
        });

        $(".gnb > ul > li > a").bind("focus", function () {
            $(".gnb_depthWrap").hide();
            $(this).siblings(".gnb_depthWrap").show();
        });

        $(".logo > a").bind("focus", function () {
            $(".gnb_depthWrap").hide();
        })
    }

    // mobile gnb button event
    $('.btn_gnb').click(function () {
        if ($(this).hasClass('on')) {
            $('header').removeClass('on');
            $(this).removeClass('on');
            $('.gnb > ul').slideUp();
        } else {
            $('header').addClass('on');
            $(this).addClass('on');
            $('.gnb > ul').css("display", "none");
            $('.gnb > ul').slideDown();
        }
    });

    // scroll header style
    $(window).on("scroll", function () {
        if ($(window).scrollTop() > 1) {
            $("header").addClass("active");
        } else {
            $("header").removeClass("active");
        }
    });

    //메뉴 바로가기, 본문 바로가기. tab or shift+tab
    $(".skip li:eq(0) a").on("focus", function (e) {
        $(".skip li a").removeClass("on");
        $(this).addClass("on");
    });
    $(".skip li:eq(0) a").on("blur", function (e) {
        $(".skip li a").removeClass("on");
    });
    $(".skip li:eq(1) a").on("focus", function (e) {
        $(".skip li a").removeClass("on");
        $(this).addClass("on");
    });
    $(".skip li:eq(1) a").on("blur", function (e) {
        $(".skip li a").removeClass("on");
    });

    // footer logo slide
    $('.footSwiper').slick({
        slide: 'li',
        arrows : false,
        infinite : true,
        autoplay: true,
        slidesToShow : 4,
        slidesToScroll : 1,
        autoplaySpeed: 2000, // 자동 넘김시 슬라이드 시간
        dots: false, //페이지 네비게이션
        speed: 1000, //슬라이드 속도
        pauseOnHover : false,// 마우스 hover시 슬라이드 멈춤
        vertical : false,
        responsive: [ // -> 반응형 옵션
            {
                breakpoint: 1024, // 반응형 ~ 1024
                settings: {
                    slidesToShow : 1,
                    slidesToScroll : 1
                }
            }
        ]
    });

    /* slick - setting */
    $('.btn_pause').click(function () {
        if ($(this).hasClass('on')) {
            $('.footSwiper').slick('slickPlay');
            $(this).removeClass('on');
        } else {
            $('.footSwiper').slick('slickPause');
            $(this).addClass('on');
        }
    })

    //footer selectbox click event
    $(".linkDown").click(function () {
        $(".familyLinks").toggleClass("on");
    })

    //외부영역 클릭 시 셀렉트 박스 닫기
    // $(document).mouseup(function (e) {
    //     if (e.target.parentElement.className != 'cmb_select') {
    //         $(".selectArea").removeClass("on");
    //     };
    // })

    //$(document).mouseup(function (e) {
    //    if (e.target.parentElement.className != 'linkDown') {
    //        $(".familyLinks").removeClass("on");
    //    };
    //})

    //info_01 box click event
    $(".btn_info01").click(function () {
        $(".tutorialsInfo01 > div").show();
    })

    $(".btn_infoCross.cross01").click(function () {
        $(".tutorialsInfo01 > div").hide();
    })

    //info_02 click event
    $(".btn_info02").click(function () {
        $(".tutorialsInfo02 > div").show();
    })

    $(".btn_infoCross.cross02").click(function () {
        $(".tutorialsInfo02 > div").hide();
    })
});