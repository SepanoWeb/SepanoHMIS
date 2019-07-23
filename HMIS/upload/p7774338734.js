
// global pmsDavaran, pmsDarkhastDavaran, pmsKargrohha, pmsDarkhasthayeerjaeshodebeAzayekargroh, cmsPyamha, pmsDarkhasthayeErjaeShodeBeSarparastKargroh */

// // Server 
// Servlet name for response to user request
var setting_server = "Server";

// main content
// this page 'on page loading' show to user automaticaly
var setting_default_sw = "صفحه اصلی";
//var setting_default_sw = "خانه"; 

// search
// this is id of
var setting_search_input_id = "#jjSearchInput";
var setting_search_input_id_btn = "#jjSearchBtn";

// public comment form setting
var setting_comment_main_panel = "#sw";
var setting_comment_afted_send_text = setting_default_sw;

// news slider
var setting_news_slider = "#jjSliderNews";
var setting_product_slider = "#jjSliderProduct";
// you must add this style to page
// <script type="text/javascript" src="js/slide/slider.js"></script>
// p#controls { margin:0; padding:0; position:relative; }
// #prevBtn { display:block; margin:0; overflow:hidden; width:16px; height:16px; position:absolute; left:-30px; top:-140px; }
// #nextBtn { display:block; margin:0; overflow:hidden; width:16px; height:16px; position:absolute; left: 650px; top:-140px; }
// #prevBtn a { display:block; width:16px; height:16px; background:url(js/slide/prev4.png) no-repeat 0 0; }
// #nextBtn a { display:block; width:16px; height:16px; background:url(js/slide/next4.png) no-repeat 0 0; }

// pic slider
var setting_flash_slider_panel = "#jjSliderFlash";
var setting_flash_slider_default_PicLink = "<a href='http://www.adobe.com/go/getflashplayer'><img src='upload/defualtPic.jpg' style='width: 150;height: 290'  alt='Get Adobe Flash player' /></a>";
var setting_flash_slider_panel_default_height = 290;
var setting_flash_slider_panel_default_width = 950;
// pic slider
var setting_pic_slider_panel = "#jjSliderPic";
var setting_pic_slider_responsive_panel = "#jjSliderPicResponsive";
var setting_pic_slider_delay = "6000";
// you must add this style to page
// <script type="text/javascript" src="js/slide/slider.js"></script>
// <script type="text/javascript" src="js/slider2/easySlider1.5.js"></script>
// .cs-buttons { display:block; margin:-32px 0 0; padding:0; font-size:0px; float:left;}
// .cs-buttons a { margin:0 2px; width:20px; height:20px; float:left; color:#fff; text-indent:-10000px; background:url(js/slide/slide_p.png) no-repeat center center;}
// .cs-buttons a.cs-active { color:#fff; background-image:url(js/slide/slide_a.png);}

//
var setting_login_exit_panel = "#jjLoginExitPanel";
// -----------------------------------------------------------------
function initCms(lang) {
    lang = lang == null ? "fa" : lang.toString().toLowerCase();
    jj(setting_server).jjSetServletName();
    if (lang == 'en') {
        $("#sw").css('direction', 'ltr');
        $("#sw").css('text-align', 'left');
    }
    if (lang == 'fa') {
        $("#sw").css('direction', 'rtl');
        $("#sw").css('text-align', 'justify');
    }
    if (lang == 'ar') {
        $("#sw").css('direction', 'rtl');
        $("#sw").css('text-align', 'justify');
    }
    jj(lang).jjSetLanguage();
    if (setting_search_input_id != "") {
        if ($(setting_search_input_id).length > 0) {
            search(setting_search_input_id);
        }
    }
    if (setting_default_sw != "") {
        sw(setting_default_sw);
    }
}
function jjNewsSlider(newsSliderDivId) {
    if (!(newsSliderDivId == null || newsSliderDivId == "")) {
        setting_news_slider = newsSliderDivId;
    }
    if (setting_news_slider != "") {
        if ($(setting_news_slider).length > 0) {
            newsSlider2(setting_news_slider);
        }
    }
}


//============ BY RASHIDI ========>
function jjProductSlider(productSliderDivId) {
    if (!(productSliderDivId == null || productSliderDivId == "")) {
        setting_product_slider = productSliderDivId;
    }
    if (setting_product_slider != "") {
        if ($(setting_product_slider).length > 0) {
            productSlider2(setting_product_slider);
        }
    }
}
//<============ BY RASHIDI ========
function jjSerchBtnInit(searchDivId) {
    if (!(searchDivId === null || searchDivId === "")) {
        setting_search_input_id_btn = searchDivId;
    }
    if (setting_search_input_id_btn !== "") {
        if ($(setting_search_input_id_btn).length > 0) {
            $(setting_search_input_id_btn).click(function () {
                if ($(setting_search_input_id).length > 0) {
                    var text = new jj(setting_search_input_id).jjVal();
                    if (text.length > 2) {
                        searchAction(text);
                    }
                }
            });
        }
    }
}
function jjAutoSlider(selector) {
    try {
        if (selector != null) {
            setting_flash_slider_panel = selector;
        }
        if (setting_flash_slider_panel != "") {
            if (setting_flash_slider_default_PicLink != "") {
                if ($(setting_flash_slider_panel).html() == "") {
                    $(setting_flash_slider_panel).html(setting_flash_slider_default_PicLink);
                }
            }
            if ($(setting_flash_slider_panel).length > 0) {
                var flashvars = {};
                flashvars.xml = "config.xml";
                if (LANGUAGE == 'en') {
                    flashvars.xml = "config_en.xml";
                }
                if (LANGUAGE == 'ar') {
                    flashvars.xml = "config_ar.xml";
                }
                flashvars.font = "font.swf";
                var attributes = {};
                attributes.wmode = "transparent";
                attributes.id = "slider";
                var panelWidth = $(setting_flash_slider_panel).css('width').replace("px", "", 0);
                var panelHeight = $(setting_flash_slider_panel).css('height').replace("px", "", 0);
                panelWidth = panelWidth == null ? setting_flash_slider_panel_default_width : panelWidth;
                panelHeight = panelHeight == null ? setting_flash_slider_panel_default_height : panelHeight;
                panelHeight = panelHeight == "404" ? setting_flash_slider_panel_default_height : panelHeight;
                swfobject.embedSWF("js/cu3er.swf", setting_flash_slider_panel.replace("#", ""), panelWidth, panelHeight, "9", "expressInstall.swf", flashvars, attributes);
            } else if (setting_pic_slider_panel != "" && $(setting_pic_slider_panel).length > 0)
            {
                picSlider(setting_pic_slider_panel, setting_pic_slider_delay);
            } else if (setting_pic_slider_responsive_panel != "" && $(setting_pic_slider_responsive_panel).length > 0)
            {
                picSlipprySlider(setting_pic_slider_responsive_panel, setting_pic_slider_delay);
            }
        }
    } catch (e) {
        setting_pic_slider_panel = setting_flash_slider_panel;
        if (setting_pic_slider_panel != "") {
            if ($(setting_pic_slider_panel).length > 0) {
                picSlider(setting_pic_slider_panel, setting_pic_slider_delay);
            }
        }
    }
}

var swArray = new Array();
function sw(titleTextOrId) {
    // ------------------  add request to Array for history --------------------
    swArray.push(titleTextOrId);
    // ------------------  clean value in titleTextOrId ------------------------
    titleTextOrId = titleTextOrId.toString().toLowerCase();
    while (titleTextOrId.indexOf("\n") > -1) {
        titleTextOrId = titleTextOrId.replace("\n", "");
    }
    while (titleTextOrId.indexOf("</span>") > -1) {
        titleTextOrId = titleTextOrId.replace("</span>", "");
    }
    while (titleTextOrId.indexOf("<span>") > -1) {
        titleTextOrId = titleTextOrId.replace("<span>", "");
    }
    titleTextOrId = new jj(titleTextOrId).jjTrim();

    // ------------------  switch sw and slider --------------------------------
    //    if(titleTextOrId=="خانه"){
    //        $('#sw').hide();
    //        $('#jjSliderPic').show();
    //        $('#jjSliderNews').show();
    //    }else{
    //        $('#sw').show();
    //        $('#jjSliderPic').hide();
    //        $('#jjSliderNews').hide();
    //    }

    // ------------------  append 'comment form' to sw -------------------------
    if (titleTextOrId.toString().toLowerCase() == "$comment") {
        $("#sw").append("<div id='pCommentDiv' class='pCommentDiv'></div>");
//        var commentPage = LANGUAGE == 'fa' ? 'public_comment_fa.html' : (LANGUAGE == 'en' ? 'public_comment_en.html' : 'public_comment_ar.html');
        var commentPage = LANGUAGE == '1' ? 'public_comment1.html' : (LANGUAGE == '2' ? 'public_comment2.html' : (LANGUAGE == '3' ? 'public_comment3.html' : (LANGUAGE == '4' ? 'public_comment4.html' : 'public_comment5.html')));//====== BY RASHIDI ======
//        alert(commentPage);
        $("#pCommentDiv").load("formCms/" + commentPage, null, function () {
            $('#insert_Comment').button().click(function () {
                if ($('#comment_full_name').val() == '') {
                    $('#comment_full_name').css("border", "red dashed");
                } else if ($('#comment_email').val() == '' && $('#comment_tell').val() == '') {
                    $('#comment_full_name').css("border", "none");
                    $('#comment_email').css("border", "red dashed");
                    $('#comment_tell').css("border", "red dashed");
                } else if ($('#comment_text').val() == '') {
                    $('#comment_full_name').css("border", "none");
                    $('#comment_tell').css("border", "none");
                    $('#comment_email').css("border", "none");
                    $('#comment_text').css("border", "red dashed");
                } else {
                    jj("do=Comment.insert&" + new jj("#swCommentForm").jjSerial()).jjAjax2(false, 'Server');
                    sw(setting_comment_afted_send_text);
                }
            });
            if (USER_NAME != '') {
                new jj('#comment_full_name').jjVal(USER_NAME + ' ' + USER_FAMILY);
                new jj('#comment_email').jjVal(USER_EMAIL);
                $('#comment_full_name').attr('disabled', 'disabled');
                $('#comment_email').attr('disabled', 'disabled');
                $('#comment_tell').focus();
            } else {
                $('#comment_full_name').focus();
            }
        });
        $("#swTitle").html("تماس با ما");
        swRightClear();
        return false;
    }
    // ------------------  append 'comment form' to sw -------------------------
    if (titleTextOrId.toString().toLowerCase() == "$comment2") {
        $("#sw").html("<div id='pCommentDiv'></div>");
        var commentPage = LANGUAGE == 'fa' ? 'public_comment_fa.html' : 'public_comment_en.html';
        $("#pCommentDiv").load("formCms/" + commentPage, null, function () {
            $('#insert_Comment').button().click(function () {
                jj("do=Comment.insert&" + new jj("#swCommentForm").jjSerial()).jjAjax2(false, 'Server');
                sw(setting_comment_afted_send_text);
            });
            if (USER_NAME != '') {
                new jj('#comment_full_name').jjVal(USER_NAME + ' ' + USER_FAMILY);
                new jj('#comment_email').jjVal(USER_EMAIL);
                $('#comment_full_name').attr('disabled', 'disabled');
                $('#comment_email').attr('disabled', 'disabled');
                $('#comment_tell').focus();
            } else {
                $('#comment_full_name').focus();
            }
        });
        $("#swTitle").html("تماس با ما");
        swRightClear();
        return false;
    }
    // ------------------  show login form dialog ------------------------------
    if (titleTextOrId.toString().toLowerCase() == "$login") {
        if (USER_NAME == '') {
            showLoginForm();
        } else {
            new jj('کاربر محترم ' + USER_NAME + "&nbsp;" + USER_FAMILY + " آیا مایلید از سیستم خارج شوید؟").jjDialog_YesNo('signOut();")', true, "خروج");
        }
        return false;
    }
    if (titleTextOrId.toString().toLowerCase() == "$loginpardakht") {
        if (USER_NAME == '') {
            showLoginFormPardakht();
        } else {
            new jj('کاربر محترم ' + USER_NAME + "&nbsp;" + USER_FAMILY + " آیا مایلید از سیستم خارج شوید؟").jjDialog_YesNo('signOut();")', true, "خروج");
        }
        return false;
    }


    // ------------------  show enrolment form ---------------------------------
    if (titleTextOrId.toString().toLowerCase() == "$enrolment") {
        $("#sw").append("<div id='enrolmentDiv'></div>");
        var enrolPage = LANGUAGE == 'fa' ? 'public_enrolment.html' : 'public_enrolment_en.html';
        $("#enrolmentDiv").load("formCms/" + enrolPage, null, function () {
            new jj('#enrolment_date').jjCalendarWithYearSelector(1340, 1380);
            $('#insert_enrolment').button().click(function () {
                jj("do=Enrolment.insert&" + new jj("#swEnrolmentFormPublic").jjSerial()).jjAjax2(false, 'Server');
                sw(setting_comment_afted_send_text);
            });

            $('#enrol_url_file').button().click(function () {
            });
            $('#upload_Enrol').button().click(function () {
                if (new jj('#enrol_url_file').jjVal() != '') {
                    $('#upload_Enrol').hide();
                    $('#enrol_url_file').hide();
                    $('#enrolment_pic').show()
                }
            });
            $('#enrolment_pic').button().click(function () {
                $('#upload_Enrol').fo();
                $('#enrol_url_file').show();
                $('#enrolment_pic').hide()
            });
            new jj('#upload_Enrol').jjAjaxFileUpload('#enrol_url_file', '#enrolment_pic', '#enrol_url_pic_demo');
            new jj('#upload_Enrol').jjAjaxFileUpload('#enrol_url_file', '#enrolment_pic1', '#enrol_url_pic_demo');//====== BY RASHIDI ======

            $('#enrol_url_file2').button().click(function () {
            });
            $('#upload_Enrol2').button().click(function () {
                if (new jj('#enrol_url_file2').jjVal() != '') {
                    $('#upload_Enrol2').hide();
                    $('#enrol_url_file2').hide();
                    $('#enrolment_file').show()
                }
            });
            $('#enrolment_file').button().click(function () {
                $('#upload_Enrol2').show();
                $('#enrol_url_file2').show();
                $('#enrolment_file').hide()
            });
            new jj('#upload_Enrol2').jjAjaxFileUpload2('#enrol_url_file2', '#enrolment_file');
            new jj('#upload_Enrol2').jjAjaxFileUpload2('#enrol_url_file2', '#enrolment_file1');//====== BY RASHIDI ======
        });
        $("#swTitle").html("فرم استخدام");
        swRightClear();
        return false;
    }
    // ------------------  show news -------------------------------------------
    if (titleTextOrId.toString().toLowerCase() == "$news") {
        swGetNews();
        swRightNewsMenu("swRight");
        return false;
    }

    // ------------------  show forum categorys --------------------------------
    if (titleTextOrId.toString().toLowerCase() == "$forum") {
        new jj("do=Category_Forum.getList&panel=sw").jjAjax2(true);
        $("#swTitle").html("انجمن ها");
        swRightClear();
        return false;
    }

    // ------------------  show polls ------------------------------------------
    if (titleTextOrId.toString().toLowerCase() == "$poll") {
        $("#swTitle").html("نظر سنجی ها");
        swRightClear();
        new jj("do=Poll.getList&panel=sw").jjAjax2(true);
        return false;
    }

    // ------------------  show pic gallery ------------------------------------
    if (titleTextOrId.toString().toLowerCase() == "$gallery") {
        $("#swTitle").html("گالری تصاویر");
        swRightClear();
        swGetGallery();
        return false;
    }
    // ------------------  show pic gallery ------------------------------------
    if (titleTextOrId.toString().toLowerCase() == "$product") {
        $("#swTitle").html("محصولات");
//        swRightProductMenu("swRight");
        swGetProducts();
        return false;
    }
    // ------------------  get data from content table  ------------------------
    new jj("do=Content.sw&text=" + titleTextOrId.toString() + "&panel=sw&title=swTitle&jj=1").jjAjax2(true);
    swRightClear();

    /*
     *@augments if menu dosnt need , it must be empty
     **/
}
;
function swRightClear() {
    $("#swRight").html("");
}


function showLoginForm() {
    if ($('#pshowLoginFormDiv').length == 0) {
        $("body").append("<div id='pshowLoginFormDiv'></div>");
        $("#pshowLoginFormDiv").load("formCms/public_login.html", null, function () {
            $('#loginBtn').button().click(function () {
                signIn();
            });
            $('#registBtn').button().click(function () {
                registInSite();
            });

            jj("#user_pass1").jjAddEnterKeyListener("signIn();");
            jj("#user_email1").jjAddEnterKeyListener("signIn();");
            jj("#user_answer").jjAddEnterKeyListener("registInSite();");
            jj("#user_birthdate").jjCalendarWithYearSelector(1320, 1380);
            $("#loginRegistForm").dialog({
                autoOpen: false,
                height: 450,
                width: 100,
                modal: true,
                title: "ورود - ثبت نام",
                buttons: {
                    "لغو": function () {
                        $(this).dialog("close");
                    }
                },
                close: function () {
                    $(this).dialog('destroy');
                }
            });
            $("#loginRegistForm").dialog("open");
            return false;
        });
    }
    $("#loginRegistForm").dialog({
        autoOpen: false,
        height: 450,
        width: 100,
        modal: true,
        title: "ورود - ثبت نام",
        buttons: {
            "لغو": function () {
                $(this).dialog("close");
            }
        },
        close: function () {
            $(this).dialog('destroy');
        }
    });
    $("#loginRegistForm").dialog("open");
}
function showLoginFormPardakht() {
    if ($('#pshowLoginFormDivPardakht').length == 0) {
        $("body").append("<div id='pshowLoginFormDivPardakht'></div>");
        $("#pshowLoginFormDivPardakht").load("formCms/public_pardakht.html", null, function () {
            $('#loginBtnPardakht').button().click(function () {
                signInPardakht();
            });
            $('#registBtnPardakht').button().click(function () {
                registInSitePardakht();
            });

            jj("#user_pass_pardakht").jjAddEnterKeyListener("signInPardakht();");
            jj("#user_email_pardakht").jjAddEnterKeyListener("signInPardakht();");
            jj("#user_answer").jjAddEnterKeyListener("registInSitePardakht();");
            jj("#user_birthdate_pardakht").jjCalendarWithYearSelector(1320, 1380);
            $("#loginRegistFormPardakht").dialog({
                autoOpen: false,
                height: 450,
                width: 1000,
                left: 0,
                modal: true,
                title: "ورود - ثبت نام",
                buttons: {
                    "لغو": function () {
                        $(this).dialog("close");
                    }
                },
                close: function () {
                    $(this).dialog('destroy');
                }
            });
            $("#loginRegistFormPardakht").dialog("open");
            return false;
        });
    }
    $("#loginRegistFormPardakht").dialog({
        autoOpen: false,
        height: 450,
        width: 1000,
        modal: true,
        left: 0,
        title: "ورود - ثبت نام",
        buttons: {
            "لغو": function () {
                $(this).dialog("close");
            }
        },
        close: function () {
            $(this).dialog('destroy');
        }
    });
    $("#loginRegistFormPardakht").dialog("open");
}
function changeLang(lang) {
    jj(lang).jjSetLanguage();
    if (swArray.length > 0) {
        sw(swArray[swArray.length - 1]);
    }
}
var someStringInSw = "$comment,$login,$enrolment,$news,$forum,$gallery,$loginpardakht";
function refreshLastSwParameter() {
    if (swArray.length > 2) {
        refreshLastSwParameter3();
        return false;
    }
    if (swArray.length > 1) {
        refreshLastSwParameter2();
        return false;
    }
    if (swArray.length > 0) {
        refreshLastSwParameter1();
        return false;
    }
}
function refreshLastSwParameter1() {
    if (someStringInSw.indexOf(swArray[swArray.length - 1]) < 0) {
        sw(swArray[swArray.length - 1]);
    }
}
function refreshLastSwParameter2() {
    if (someStringInSw.indexOf(swArray[swArray.length - 1]) < 0) {
        sw(swArray[swArray.length - 1]);
    }
}
function refreshLastSwParameter3() {
    if (someStringInSw.indexOf(swArray[swArray.length - 2]) < 0) {
        sw(swArray[swArray.length - 2]);
    }
}
function loginUserSabteNam(){
 var param = "";
    param += "do=Access_User.loginUserSabteNam";
    jj(param).jjAjax2();
}
function loginUserSamaneyeElsaleAsar(){
 var param = "";
    param += "do=Access_User.loginUserSamaneyeElsaleAsar";
    jj(param).jjAjax2();
}




function signIn() {
    if (new jj('#login_user_email').jjVal() == '') {
        $("#login_user_email").css("border", "red dashed");
        $("#loginMessagePanel").html("ایمیل  نباید تهی باشد.");
        return false;
    } else if (new jj('#login_user_pass').jjVal() == '') {
        $("#login_user_email").css("border", "none");
        $("#login_user_pass").css("border", "red dashed");
        $("#loginMessagePanel").html("رمز عبور نباید تهی باشد.");
        return false;
    }
    $("#login_user_email").css("border", "none");
    $("#login_user_pass").css("border", "none");


    jj("do=Access_User.loginUser&panel=" + setting_login_exit_panel.replace("#", "") + "&" + new jj("#loginForm").jjSerial()).jjAjax2(false);
    USER_EMAIL = new jj('#login_user_email').jjVal();

}
;
function signInPardakht() {
//    if (new jj('#user_email_pardakht').jjVal() == '') {
//        $("#user_email_pardakht").css("border", "red dashed");
//        $("#loginMessagePanel").html("ایمیل  نباید تهی باشد.");
//        return false;
//    } else if (new jj('#user_pass_pardakht').jjVal() == '') {
//        $("#user_email_pardakht").css("border", "none");
//        $("#user_pass_pardakht").css("border", "red dashed");
//        $("#loginMessagePanel").html("رمز عبور نباید تهی باشد.");
//        return false;
//    }
//    $("#user_email_pardakht").css("border", "none");
//    $("#user_pass_pardakht").css("border", "none");
    var flag = true;
    ///name (E)
    var email = $("#user_email_pardakht").val();
    if (validateenglish(email) && new jj('#user_email_pardakht').jjVal() !== "") {
        $('#user_email_pardakht').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel1").html('');

//        validateflag = true;
    } else {
        $("#user_email_pardakht").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
//        $("#errorRegistMessagePanel1").html('');
//        $("#errorRegistMessagePanel1").append('لطفا ایمیل وارد کنید');
        flag = false;
    }
    var email = $("#user_pass_pardakht").val();
    if (validateenglish(email) && new jj('#user_pass_pardakht').jjVal() !== "") {
        $('#user_pass_pardakht').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
//        $("#errorRegistMessagePanel2").html('');

//        validateflag = true;
    } else {
        $("#user_pass_pardakht").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
//        $("#errorRegistMessagePanel2").html('');
//        $("#errorRegistMessagePanel2").append('لطفا پسورد وارد کنید');
        flag = false;
    }
    jj("do=Access_User.loginUserPardakht&panel=" + setting_login_exit_panel.replace("#", "") + "&" + new jj("#loginFormPardakht").jjSerial()).jjAjax2(false);
    USER_EMAIL = new jj('#user_email_pardakht').jjVal();

}
;
function signInSafheAsli() {
    if (new jj('#login_user_email').jjVal() == '') {
        $("#login_user_email").css("border", "red dashed");
        $("#loginMessagePanel").html("ایمیل  نباید تهی باشد.");
        return false;
    } else if (new jj('#login_user_pass').jjVal() == '') {
        $("#login_user_email").css("border", "none");
        $("#login_user_pass").css("border", "red dashed");
        $("#loginMessagePanel").html("رمز عبور نباید تهی باشد.");
        return false;
    }
    $("#login_user_email").css("border", "none");
    $("#login_user_pass").css("border", "none");
    jj("do=Access_User.loginUserSafheAsli&panel=" + setting_login_exit_panel.replace("#", "") + "&" + new jj("#loginForm").jjSerial()).jjAjax2(false);
    USER_EMAIL = new jj('#login_user_email').jjVal();

}
;
function validateEmail(email) {
    var emailPathern = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
//    var re = /^.*$/;
    return emailPathern.test(email);
}
function validatePhone(mobile) {
    var regx = /^(09|9)[0-9]{9}$/;
    return regx.test(mobile);
}
function validateweblog(weblog) {
    var regy = /^w{3}\.[a-z]+\.?[a-z]{2,3}(|\.[a-z]{2,3})$/;
    return regy.test(weblog);
}
function validateshomareshenasname(shomareshenasname) {
    var regx = /^[0-9]{1,10}$/;
    return regx.test(shomareshenasname);
}
function validatepersion(string) {
    var regx = /^([\u0600-\u06FF].{1,90}\s*)$/;
    return regx.test(string);
}
//function validateLanguage1(family) {
//    var regx = /^[\u0600-\u06FF]+$/;
//    return regx.test(family);
//}
//function validateLanguage2(sazman) {
//    var regx = /^[\u0600-\u06FF]+$/;
//    return regx.test(sazman);
//}
//function validateLanguage3(takhasus) {
//    var regx = /^[\u0600-\u06FF]+$/;
//    return regx.test(takhasus);
//}
function validateenglish(string) {
    var regx = /^[a-z ,.'-]+$/i;
    return regx.test(string);
}
function validatePass(lastname) {
    var regx = (/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/);
    return regx.test(lastname);
}
//function validatePass(lastname) {
//    var regx=/^[A-Za-z]{8,}$/;
////    var regx = (/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/);
//    return regx.test(lastname);
//}
//function validateLanguages(organ) {
//    var regx = /^[A-Za-z]{3,}$/;
//    return regx.test(organ);
//}
//function validateLanguages(expertise) {
//    var regx = /^[A-Za-z]{3,}$/;
//    return regx.test(expertise);
//}
function validatecodemeli(codemeli) {
    var regx = /^[0-9]{10}$/;
    return regx.test(codemeli);
}


function registInSite() {
    var flag = true;
    ///name (E)
    var name = $("#user_name").val();
    if (validateenglish(name) && new jj('#user_name').jjVal() !== "") {
        $('#user_name').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel1").html('');

//        validateflag = true;
    } else {
        $("#user_name").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel1").html('');
        $("#errorRegistMessagePanel1").append('لطفا نام خود را به انگلیسی وارد کنید');
        flag = false;
    }
//
//    ///name (E)
//    ///family (E)
    var lastname = $("#user_lastname").val();
    if (validateenglish(lastname) && new jj('#user_lastname').jjVal() !== "") {
        $('#user_lastname').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel2").html('');

//        validateflag = true;
    } else {
        $("#user_lastname").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel2").html('');
        $("#errorRegistMessagePanel2").append('لطفا نام خانوادگی خودبه انگلیسی راوارد کنید');
        flag = false;
    }
//
//
//    ///family (E)
//    ///sazman (E)
//   
    var organ = $("#user_organ").val();
    if (validateenglish(organ) && new jj('#user_organ').jjVal() !== "") {
        $('#user_organ').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel3").html('');

//        validateflag = true;
    } else {
        $("#user_organ").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel3").html('');
        $("#errorRegistMessagePanel3").append('لطفا نام سازمان خودبه انگلیسی راوارد کنید');
        flag = false;
    }
    var organ = $("#user_afillation").val();
    if (validateenglish(organ) && new jj('#user_afillation').jjVal() !== "") {
        $('#user_afillation').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel21").html('');

//        validateflag = true;
    } else {
        $("#user_afillation").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel21").html('');
        $("#errorRegistMessagePanel21").append('لطفا نام وابستگی خودبه  انگلیسی وارد کنید');
        flag = false;
    }

//    ///SAZMAN(E)
//    ///TAKHASUS(E)
//    
//    var expertise = $("#user_expertise").val();
//    if (validateenglish(expertise) && new jj('#user_expertise').jjVal() != "") {
//        $('#user_expertise').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
//        $("#errorRegistMessagePanel4").html('');
//
////        validateflag = true;
//    } else {
//        $("#user_expertise").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
//        $("#errorRegistMessagePanel4").html('');
//        $("#errorRegistMessagePanel4").append('لطفا تخصص خودبه انگلیسی راوارد کنید');
//        flag = false;
//    }
////
////
////    ///TAKHASUS(E)
    var pass = $("#user_pass").val();
    if (validatePass(pass) && new jj('#user_pass').jjVal() != "") {
        $('#user_pass').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel5").html('');

//        validateflag = true;
    } else {
        $("#user_pass").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel5").html('');
        $("#errorRegistMessagePanel5").append('برای رمز عبور لطفاحداقل 8کاراکتر وارد نمایید.');
        flag = false;
    }
    if (new jj('#user_pass_2').jjVal() != new jj('#user_pass').jjVal()) {
        $('#user_pass_2').css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel6").html('');
        $("#errorRegistMessagePanel6").append('لطفا تکرار پسورد خود راوارد کنید');
        flag = false;
    } else {
        $('#user_pass_2').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel6").html('');
    }
    var email = $("#user_email").val();
    if (validateEmail(email) && new jj('#user_email').jjVal() !== "") {
        $('#user_email').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
//        validateflag = true;
        $("#errorRegistMessagePanel7").html('');
    } else {
        $("#user_email").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel7").html('');
        $("#errorRegistMessagePanel7").append('لطفا ایمیل خود راوارد کنید');
        flag = false;
    }
//
//    var weblog = $("#user_weblog").val();
//
//    if (validateweblog(weblog) && new jj('#user_weblog').jjVal() !== "") {
//        $('#user_weblog').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
//        $("#errorRegistMessagePanel8").html('');
////        validateflag = true;
//    } else {
//        $("#user_weblog").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
//        $("#errorRegistMessagePanel8").html('');
//        $("#errorRegistMessagePanel8").append('لطفا وب سایت خود را وارد کنید');
//
//        flag = false;
//    }

    ///NAME(F)
    var name = $("#user_nam").val();

    if (validatepersion(name) && new jj('#user_nam').jjVal() != "") {
        $('#user_nam').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel9").html('');
//        validateflag = true;
    } else {
        $("#user_nam").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel9").html('');
        $("#errorRegistMessagePanel9").append('لطفا نام خودبه فارسی راوارد کنید');
        flag = false;
    }
////NAME(F)

    ////FAMILY(F)

    var family = $("#user_family").val();

    if (validatepersion(family) && new jj('#user_family').jjVal() !== "") {
        $('#user_family').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel10").html('');
//        validateflag = true;
    } else {
        $("#user_family").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel10").html('');
        $("#errorRegistMessagePanel10").append('لطفا نام خانوادگی  خودبه فارسی راوارد کنید');
        flag = false;
    }
    ///FAMILY(F)
    ///SAZMAN(F)
    var sazman = $("#user_sazman").val();

    if (validatepersion(sazman) && new jj('#user_sazman').jjVal() !== "") {
        $('#user_sazman').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel11").html('');
//        validateflag = true;
    } else {
        $("#user_sazman").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel11").html('');
        $("#errorRegistMessagePanel11").append('لطفا سازمان  خودبه فارسی راوارد کنید');
        flag = false;
    }
    ///SAZMAN(F)
    ///TAKHASUS(F)

//       
//    var takhasus = $("#user_takhasus").val();
//
//    if (validatepersion(takhasus) && new jj('#user_takhasus').jjVal() !== "") {
//        $('#user_takhasus').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
//        $("#errorRegistMessagePanel12").html('');
////        validateflag = true;
//    } else {
//        $("#user_takhasus").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
//        $("#errorRegistMessagePanel12").html('');
//        $("#errorRegistMessagePanel12").append('لطفا تخصص  خود را به فارسی وارد کنید');
//
//        flag = false;
//    }
//    ////TAKHSUS(F)
//
//
//
//
    if (new jj('#user_address').jjVal() == '') {
        $('#user_address').css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel13").html('');
        $("#errorRegistMessagePanel13").append('لطفا آدرس خود را  وارد کنید');
        flag = false;
    } else {
        $('#user_address').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel13").html('');
    }

    if (new jj('#user_grade').jjVal() == '') {
        $('#user_grade').css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel14").html('');
        $("#errorRegistMessagePanel14").append('لطفا رتبه ی علمی را  وارد کنید');
        flag = false;
    } else {
        $('#user_grade').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel14").html('');
    }

    if (new jj('#user_reshte').jjVal() == '') {
        $('#user_reshte').css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel19").html('');
        $("#errorRegistMessagePanel19").append('لطفارشته تحصیلی خود را  وارد کنید');
        flag = false;
    } else {
        $('#user_reshte').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel19").html('');
    }
    if (new jj('#user_birthdateSamane').jjVal() == '') {
        $('#user_birthdateSamane').css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel20").html('');
        $("#errorRegistMessagePanel20").append('لطفاتاریخ تولد خود را  وارد کنید');
        flag = false;
    } else {
        $('#user_birthdateSamane').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel20").html('');
    }
    if (new jj('#user_jensiat').jjVal() == '') {
        $('#user_jensiat').css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel18").html('');
        $("#errorRegistMessagePanel18").append('لطفاجنسیت خود را  وارد کنید');
        flag = false;
    } else {
        $('#user_jensiat').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel18").html('');
    }
//
//
    var mobile = $("#user_mobile").val();
    if (validatePhone(mobile) && new jj('#user_mobile').jjVal() !== "") {
        $('#user_mobile').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
//        validateflag = true;
        $("#errorRegistMessagePanel15").html('');
    } else {
        $("#user_mobile").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel15").html('');
        $("#errorRegistMessagePanel15").append('لطفا موبایل خود راوارد کنید');
        flag = false;
    }

//   
    var codemeli = $("#user_codemeli").val();
    if (validatecodemeli(codemeli) && new jj('#user_codemeli').jjVal() !== "") {
        $('#user_codemeli').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel16").html('');

//        validateflag = true;
    } else {
        $("#user_codemeli").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel16").html('');
        $("#errorRegistMessagePanel16").append('لطفاکد ملی خودراوارد کنید');
        flag = false;
    }
//    
    var shomareshenasname = $("#user_shomareShenasname").val();
    if (validateshomareshenasname(shomareshenasname) && new jj('#user_shomareShenasname').jjVal() !== "") {
        $('#user_shomareShenasname').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel17").html('');

//        validateflag = true;
    } else {
        $("#user_shomareShenasname").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel17").html('');
        $("#errorRegistMessagePanel17").append('لطفاشماره شناسنامه خودراوارد کنید');
        flag = false;
    }
//
////   
////    
////     
////    if (new jj('#user_password_hint').jjVal() == '') {
////        $('#user_password_hint').css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
////        flag = false;
////    }
    if (!flag) {
        return;
    }

    jj("do=Access_User.registUser&panel=" + setting_login_exit_panel.replace("#", "") + "&" + new jj("#registForm").jjSerial()).jjAjax2(false);
//    $("#registerBtn").hide();

//    jj("do=Access_User.registUser&" + new jj("#registForm").jjSerial()).jjAjax2(false);
}
function registInSitePardakht() {
    var flag = true;


    var pass = $("#user_pass_pardakht2").val();
    if (new jj('#user_pass_pardakht2').jjVal() != "" && validatePass(pass) == true) {
        $('#user_pass_pardakht2').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel5").html('');
    } else {
        $("#user_pass_pardakht2").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel5").html('');
        $("#errorRegistMessagePanel5").append('برای رمز عبور لطفاحداقل 8کاراکتر وارد نمایید.');
        flag = false;
    }

    
    
    
    if (new jj('#user_pass_2_pardakht').jjVal() != new jj('#user_pass_pardakht2').jjVal()) {
        $('#user_pass_2_pardakht').css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel6").html('');
        $("#errorRegistMessagePanel6").append('لطفا تکرار پسورد خود راوارد کنید');
        flag = false;
    } else {
        $('#user_pass_2_pardakht').css("box-shadow", "2px 0px 10px 2px rgba(70, 178, 200, 0.8)");
        $("#errorRegistMessagePanel6").html('');
    }
    var email = $("#user_email_pardakht2").val();
    if (validateEmail(email) && new jj('#user_email_pardakht2').jjVal() !== "") {
        $('#user_email_pardakht2').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
//        validateflag = true;
        $("#errorRegistMessagePanel7").html('');
    } else {
        $("#user_email_pardakht2").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel7").html('');
        $("#errorRegistMessagePanel7").append('لطفا ایمیل خود راوارد کنید');
        flag = false;
    }


    var name = $("#user_nam_pardakht").val();

    if (validatepersion(name) && new jj('#user_nam_pardakht').jjVal() != "") {
        $('#user_nam_pardakht').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel9").html('');
//        validateflag = true;
    } else {
        $("#user_nam_pardakht").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel9").html('');
        $("#errorRegistMessagePanel9").append('لطفا نام خودبه فارسی راوارد کنید');
        flag = false;
    }
////NAME(F)

    ////FAMILY(F)

    var family = $("#user_family_pardakht").val();

    if (validatepersion(family) && new jj('#user_family_pardakht').jjVal() !== "") {
        $('#user_family_pardakht').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel10").html('');
//        validateflag = true;
    } else {
        $("#user_family_pardakht").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel10").html('');
        $("#errorRegistMessagePanel10").append('لطفا نام خانوادگی  خودبه فارسی راوارد کنید');
        flag = false;
    }

    if (new jj('#user_birthdate_pardakht').jjVal() == '') {
        $('#user_birthdate_pardakht').css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel20").html('');
        $("#errorRegistMessagePanel20").append('لطفاتاریخ تولد خود را  وارد کنید');
        flag = false;
    } else {
        $('#user_birthdate_pardakht').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel20").html('');
    }

//
//

//    if (!flag) {
//        return;
//    }
var param="";
// param += "&email=" + jj("#user_email_pardakht2").jjVal();
  param += "do=Access_User.registUserPardakht" ;
      param += "&"+ new jj("#registFormPardakht").jjSerial();
    jj(param).jjAjax2();
//    email = new jj('#user_email_pardakht2').jjVal();
//    jj("do=Access_User.registUserPardakht&panel=" + new jj("#registFormPardakht").jjSerial() + "&EmailPardakhtha=" + jj("#user_email_pardakht2").jjVal()).jjAjax2(false);
//    jj("do=Access_User.registUserPardakht" + new jj("#registFormPardakht").jjSerial()).jjAjax2(false);

}
function signOut() {
    USER_NAME = "";
    USER_FAMILY = "";
    USER_EMAIL = "";
    USER_PASS = "";
    new jj("do=Access_User.signOut").jjAjax2(true);
//    $("#loginForm").show();
//    $("#jjLoginExitPanel").html('ورود / ثبت نام');
//    window.location = 'index_MySite.html';
    $("countPayamhaDidenashode").html('');
//reportStatus.();
//payamhayeman
//window.location = 'Server2?do=Category_Product.getSelectOptions&panel=swSelectOptions&id=0&jj=1';
//    showSabtenam();
//     $("#loginForm").show();
}
function signOutCms() {
    USER_NAME = "";
    USER_FAMILY = "";
    USER_EMAIL = "";
    USER_PASS = "";
    new jj("do=Access_User.signOutCms").jjAjax2(true);
//    $("#loginForm").show();
//    $("#jjLoginExitPanel").html('ورود / ثبت نام');
//    window.location = 'index_MySite.html';
    $("countPayamhaDidenashode").html('');
//reportStatus.();
//payamhayeman
//window.location = 'Server2?do=Category_Product.getSelectOptions&panel=swSelectOptions&id=0&jj=1';
//    showSabtenam();
//     $("#loginForm").show();
}
//function Exit(){
//    
//      $("#darkhast").hide();  
//      $("#loginForm").show();  
//      $("#recover").hide();  
//      $("#payamhayeDaryafti").hide();  
//      $("#payamhayeman").hide();  
//      $("#payamhayeErsali").hide();  
//      $("#payamHayeManTbl").hide();  
//    
//} 
function swGetNewsCategory() {
    new jj("do=News.getList&panel=sw&id=0&jj=1").jjAjax2(true);//id=0=> top news(slider + priority 2)
}
function swGetForumCategory() {
    new jj("do=Category_Forum.getList&panel=sw").jjAjax2(true);
}
function swVoteToPoll(pollId, whichOneRecord) {
    if (USER_NAME == '') {
        sw('$login');
        return false;
    } else {
        new jj("do=Poll.voteToPoll&pollId=" + pollId + "&whichRecord=" + whichOneRecord).jjAjax2(true);
    }
}
function swGetGallery(galleryId) {
    var tempid = (galleryId) ? galleryId : "0";
    new jj("do=Pic.getGallery&panel=sw&id=" + tempid).jjAjax2(true);
    swRightClear();
}
function swGetProducts(productId) {
     $("#loginFormSamane").hide();
    var tempid = (productId) ? productId : "0";
    new jj("do=Product.getList&panel=sw&id=" + tempid + "&jj=1&title=swTitle").jjAjax2(true);
//    swOptionsMenu("swSelectOptions");

}
function showShare() {
    $("#share").show();
}


/**
 *این تابع تازه های نشر است
 *سمت سرور انهایی که اولویت دو دارند را انتخاب و سمت کلینت بصورت اسلایدر تک تک نشان میدهد
 *خروجی بوت استرپ است
 * @param {type} newsId
 * @returns {undefined}
 */

function swGetProductsTazeha(pannel) {
//    swRightProductMenu("swRight");
    var pannelDiv = (pannel) ? pannel : "swProductTazeha";
    new jj("do=Product.getListTazehha&panel=" + pannelDiv + "&jj=1&title=swTitle").jjAjax2(true);
}
/**
 * تبدیل به اسلیک اسلایدر
 * @returns {undefined}
 */
var runTazehaSlider = function () {
    $('.ProductTazeha').slick({
        dots: false,
        rtl: true,
        infinite: true,
        speed: 500,
        slidesToShow: 3,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 2000,
        arrows: true,
        responsive: [{
                breakpoint: 600,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            },
            {
                breakpoint: 400,
                settings: {
                    arrows: false,
                    slidesToShow: 1,
                    slidesToScroll: 1
                }
            }]
    });
};

/**
 *این تابع تازه های نشر است
 *سمت سرور انهایی که اولویت سه
 * دارند را انتخاب و سمت کلینت بصورت اسلایدر تک تک نشان میدهد
 *خروجی بوت استرپ است
 *
 * @param {int} priority اگر خالی نباشد آن اولویت را می آورد
 * @returns {undefined}
 */
function swGetProductsPorforoushha(pannel) {
//    swRightProductMenu("swRight");
    var pannelDiv = (pannel) ? pannel : "swProductPorforoushha";
    new jj("do=Product.getListPorforoushha&panel=" + pannelDiv + "&jj=1&title=swTitle").jjAjax2(true);
}


/**
 * تبدیل به اسلیک اسلایدر
 * @returns {undefined}
 */
var runPorforoushSlider = function () {
    $('.productPorforoushha').slick({
        dots: false,
        rtl: true,
        infinite: true,
        speed: 500,
        slidesToShow: 3,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 2000,
        arrows: true,
        responsive: [{
                breakpoint: 600,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            },
            {
                breakpoint: 400,
                settings: {
                    arrows: false,
                    slidesToShow: 1,
                    slidesToScroll: 1
                }
            }]
    });
};

function getOneproduct(newsId) {

    if (jj(newsId).jjIsDigit()) {
        new jj("do=Product.getOneProduct&id=" + newsId.toString() + "&panel=sw&jj=1&title=swTitle").jjAjax2(true);
        getProductMenu("ulMenuProducts");
        swRightProductMenu("swRight");
//         $("#commentForm").load("formCms/comment.html");
        //        $('#sliderPanel').hide();
        //        $('#bodyPanel').show();
        //        $('#sw').show();
        //        swTab(3);

    }
}
;
function swRightProductMenu(panel) {
    if ($("#swRight").html() == "") {
        var panel = (panel) ? panel : "swRight";
        new jj("do=Category_Product.getHierarchyDiv&panel=" + panel + "&id=0&jj=1").jjAjax2();
    }
}
//============ BY RASHIDI ========>
function swOptionsMenu(panel) {
    var panel = (panel) ? panel : "swSelectOptions";
    new jj("do=Category_Product.getSelectOptions&panel=" + panel + "&id=0&jj=1").jjAjax2();
}
function getProductMenu(panel) {
    var panel = (panel) ? panel : "ulMenu";
    new jj("do=Category_Product.getMenu&panel=" + panel + "&id=0&jj=1").jjAjax2();
}
//<============ BY RASHIDI ========
function swRightNewsMenu(panel) {
    var panel = (panel) ? panel : "swRight";
    new jj("do=Category_News.getHierarchyDiv&panel=" + panel + "&id=0&jj=1").jjAjax2(true);
}

function picDialog(address, title) {
    //    new jj(address).jjDialog(true,' ',10,750);
    //    new jj("<img  src="+address+" style='width:98%'/>").jjDialog(true,title,window.screen.height*90/100,"98%");
    //    alert(title);
    new jj("<img  src=" + address + " style='width:100%'/>").jjDialog(true, title, 650, 750);
}
function swGetNews(newsCategoryId) {
    var catId = (newsCategoryId) ? newsCategoryId : "0";
    new jj("do=News.getList&id=" + catId + "&panel=sw&jj=1&title=swTitle").jjAjax2(true);
}
function newsDisLike(newsId) {
    var temp = $("#swTopNewsDiv").html();
    temp = temp.replace("onclick=\"newsLike(" + newsId + ");\"", "");
    temp = temp.replace("onclick=\"newsDisLike(" + newsId + ");\"", "");
    $("#swTopNewsDiv").html(temp);
    new jj("do=News.newsDisLike&id=" + newsId).jjAjax2(true);
    jj("سپاس از همکاری شما.نظر شما بزودی در سیستم اعمال می شود...").jjDialog();
}
;
function newsLike(newsId) {
    var temp = $("#swTopNewsDiv").html();
    temp = temp.replace("onclick=\"newsLike(" + newsId + ");\"", "");
    temp = temp.replace("onclick=\"newsDisLike(" + newsId + ");\"", "");
    $("#swTopNewsDiv").html(temp);
    new jj("do=News.newsLike&id=" + newsId).jjAjax2(true);
    jj("سپاس از همکاری شما.نظر شما بزودی در سیستم اعمال می شود...").jjDialog();
}
;

//By Md
function productDisLike(productId) {
    alert("سپاس از همکاری شما.نظر شما بزودی در سیستم اعمال می شود...");
    $(".prDLDiv").attr("onclick", "");
    new jj("do=Product.productDisLike&id=" + productId).jjAjax2(true);
}
;

//By Md
function productLike(productId) {
    alert("سپاس از همکاری شما.نظر شما بزودی در سیستم اعمال می شود...");
    $(".prLDiv").attr("onclick", "");
    new jj("do=Product.productLike&id=" + productId).jjAjax2(true);
}
;
//============ BY RASHIDI ========>
function calculatePrice(prId) {//با تغییر تعداد هر کالای موجود در سبد خرید مجموع قیمت آن کالا تغییر می کند
    var unitPrice = $("#prRowTr" + prId + " .unitPrice").html();
    var num = $("#prRowTr" + prId + " .inputNum").val();
    $("#prRowTr" + prId + " .sumPrice").html(parseInt(unitPrice) * num);
    refreshSumPrice();
}
function refreshSumPrice() {// آپدیت شدن قیمت کل پرداختی
    var sum = 0;

    $(".shoppingCart .sumPrice").each(function () {
        sum += parseInt($(this).html());
    });
    $("#finalPrice").html(sum);
    $("#account_factor_sum").val(sum);
}
function calculatePriceDiscount(prId) {//با تغییر تعداد هر کالای موجود در سبد خرید مجموع قیمت آن کالا تغییر می کند
    var unitPrice = $("#prRowTr" + prId + " .discount").html();
    var num = $("#prRowTr" + prId + " .inputNum").val();
    $("#prRowTr" + prId + " .sumPrice").html(parseInt(unitPrice) * num);
    refreshSumPrice();
}
function refreshSumPriceDiscount() {// آپدیت شدن قیمت کل پرداختی
    var sum = 0;

    $(".shoppingCart .sumPrice").each(function () {
        sum += parseInt($(this).html());
    });
    $("#finalPrice").html(sum);
    $("#account_factor_sum").val(sum);
}

function addToShoppingCart(productId) {//آی دی کالای انتخابی را به کوکی اضافه می کند.

//    new jj('productId=' + productId).jjAjaxCookie();//با سرولته مربوط به کوکی کار میکنه
    if (new jj('productsId').jjCookieGet().replace("%2C", ",").indexOf(productId) < 0) {//اگر این کالا قبلا انتخاب نشده باشد
        if (new jj('productsId').jjCookieGet() !== "") {//قبلا کوکی ست شده است
            new jj('productsId').jjCookieUpdate(productId + ',');
            new jj('productNums').jjCookieUpdate(1);
            $("#productNums").html(new jj('productNums').jjCookieGet());
            new jj('کالا به سبد خرید اضافه شد.').jjDialog();
//        new jj('productId=' + productId).jjAjaxCookie();//تابعی که درخواست رو به کوکی سرولت میفرسته.
        } else {//تا حالا کوکی ست نشده
//        alert(productId);
            new jj('productsId').jjCookieSave(productId + ',');
            new jj('productNums').jjCookieSave(1);
            $("#productNums").html(1);
            showShoppingCart();
        }
    } else {
        new jj('این کالا پیش از این انتخاب شده است.').jjDialog();
    }

}
;
function showShoppingCart() {//تابعی که سبد خرید را به صورت جدول می سازد فراخوانی میکند
    $("#loginFormSamane").hide();
//    $("#swRight").html("");
    if (new jj('productsId').jjCookieGet() !== "") {
        swRightClear();
        new jj("do=Product.buildShoppingCart&panel=sw").jjAjax2(true);
    } else {//تا حالا کوکی ست نشده
//        alert('کالایی انتخاب نشده است.')
        new jj('کالایی انتخاب نشده است').jjDialog();
    }

}
;
function showShoppingCartAfterLogin() {//تابعی که سبد خرید را به صورت جدول می سازد فراخوانی میکند
    if (new jj('productsId').jjCookieGet() !== "") {
        swRightClear();
        new jj("do=Product.buildShoppingCart&panel=sw").jjAjax2(true);

    } else {//تا حالا کوکی ست نشده
//        alert('کالایی انتخاب نشده است.')
        new jj('کالایی انتخاب نشده است').jjDialog();
    }

}
;
function deletePrFromCart(productId) {
    new jj("آیا از حذف این محصول اطمینان دارید؟").jjDialog_YesNo('afterDeletePrFromCart(' + productId + ');\n', true, "");
}
function afterDeletePrFromCart(productId) {//آیتمی را از سبد خرید حذف میکند.
    new jj('productsId').jjCookieReplace(productId + ",", "");
    new jj('productNums').jjCookieUpdate(-1);
    $("#productNums").html(new jj('productNums').jjCookieGet());
    $("#prRowTr" + productId).remove();
//    $("#product" + productId).remove();
    refreshSumPrice();
}
;
//function prePayment() {
//
//    if (!$(".bankDiv label input").is(':checked')||(!$(".A label input").is(':checked'))) {
//        $(".bankDiv").css("border", "1px red dashed");
//        $(".A").css("border", "1px red dashed");
//
//    }
//    if (!$(".bankDiv label input").is(':checked')||(!$(".A label input").is(':checked'))) {
//        $(".bankDiv").css("border", "1px red dashed");
//        $(".A").css("border", "1px red dashed");
//
//    }
//    else if ((new jj('#address1').jjVal() == '') && ($('input:radio[name=user_address1]:checked'))) {
//        $("#address1").css("border", "1px red dashed");
//
//        $(".bankDiv").css("border", "0px gray dashed");
//        $(".A").css("border", "0px gray dashed");
//    }
//     else if ((new jj('#address2').jjVal() == '') && ($('input:radio[id=user_address2]:checked'))) {
//        $("#address2").css("border", "1px red dashed");
//
//        $(".bankDiv").css("border", "0px gray dashed");
//        $(".A").css("border", "0px gray dashed");
//    }
//     else if ((new jj('#address3').jjVal() == '') && ($('input:radio[id=user_address3]:checked'))) {
//        $("#address3").css("border", "1px red dashed");
//
//        $(".bankDiv").css("border", "0px gray dashed");
//        $(".A").css("border", "0px gray dashed");
//    }
//   
// 
//
//    else {
//        $("#address1").css("border", "1px gray solid");
//        $("#address2").css("border", "1px gray solid");
//        $("#address3").css("border", "1px gray solid");
//        $(".A").css("border", "0px gray dashed");
//        $(".bankDiv").css("border", "0px gray dashed");
//        var param = new jj("#sw").jjSerial();
//
//        new jj("do=Factor.insertFactor&" + param).jjAjax2(true);//ثبت فاکتور در دیتابیس
////    new jj("do=Factor.insertFactor&").jjAjax2(true);//ثبت فاکتور در دیتابیس
//    }
//}
//
function prePayment() {
 $("#loginFormSamane").hide();
    if (!$(".bankDiv label input").is(':checked')) {
        $(".bankDiv").css("border", "1px red dashed");
    } else {
        $(".bankDiv").css("border", "0px gray dashed");
    }
    if (!$(".A label input").is(':checked')) {
        $(".A").css("border", "1px red dashed");
    }
    else {
        if (new jj('#address1').jjVal() == '' && $("#radio1").is(":checked")) {
            $("#address1").css("border", "1px red dashed");
            $(".A").css("border", "0px gray dashed");

        } else if (!new jj('#address1').jjVal() == '' && $("#radio1").is(":checked")) {
            $(".A").css("border", "0px gray dashed");
        }

        if (new jj('#address2').jjVal() == '' && $("#radio2").is(":checked")) {
            $("#address2").css("border", "1px red dashed");
            $(".A").css("border", "0px gray dashed");

        }
        else if (!new jj('#address2').jjVal() == '' && $("#radio2").is(":checked")) {
            $(".A").css("border", "0px gray dashed");
        }

        if (new jj('#address3').jjVal() == '' && $("#radio3").is(":checked")) {
            $("#address3").css("border", "1px red dashed");
            $(".A").css("border", "0px gray dashed");

        }


        else if (!new jj('#address3').jjVal() == '' && $("#radio3").is(":checked")) {
            $(".A").css("border", "0px gray dashed");
        }






        if ($(".A label input").is(':checked') && $(".bankDiv label input").is(':checked') && (!new jj('#address1').jjVal() == '' || !new jj('#address2').jjVal() == '' || !new jj('#address3').jjVal() == '')) {


            var param = "";
//            $("#address2").css("border", "1px gray solid");
//            $("#address3").css("border", "1px gray solid");
//            $("#address1").css("border", "1px gray solid");


            $(".bankDiv").css("border", "0px gray dashed");
            $(".A").css("border", "0px gray dashed");
            if ($("#radio3").is(":checked")) {

                param += "&address3" + "=" + new jj('#address3').jjVal();
                $('#address2').removeAttr('name', '');
                $('#address1').removeAttr('name', '');

            }
            if ($("#radio2").is(":checked")) {
                param += "&address2" + "=" + new jj('#address2').jjVal();
                $('#address3').removeAttr('name', '');
                $('#address1').removeAttr('name', '');

            }
            if ($("#radio1").is(":checked")) {
                param += "&address1" + "=" + new jj('#address1').jjVal();
                $('#address2').removeAttr('name', '');
                $('#address3').removeAttr('name', '');

            }

            param += "&" + new jj("#sw").jjSerial();

            param += "&do=Factor.insertFactor";
           $("#swRight").html("");

            new jj(param).jjAjax2(true);//ثبت فاکتور در دیتابیس


        }

    }

}
function prePaymentBeforelolgin() {

    var param = "";
    param += "&do=Factor.insertFactor";

    new jj(param).jjAjax2(true);//ثبت فاکتور در دیتابیس

}
function nameDargah(name, factorSum) {
    var param = "";
//    param += amount + $("#finalPrice").html();
//    param +="&factorId="+$("#factorId").val();
    param += "&factorSum=" + factorSum;
    param += "&do=" + name + ".doPayment";
    jj(param).jjAjax2(false);
}

function payment(factorSum) {//عملیات پرداخت
    if ($('#acceptConditions:checked').size() > 0) {//قبول قوانین و مقررات
        clearShopingCart();
        var param = new jj("#sw").jjSerial();
        new jj("do=Payment.payment&payment_amount=" + factorSum + "&" + param).jjAjax2(true);
        new jj("لطفا کمی صبر کنید تا به صفحه پرداخت منتقل شوید").jjDialog();
    }
}
;
function clearShopingCart() {//آیتمی را از سبد خرید حذف میکند.
    jj('productsId').jjCookieDelete();
    jj('productNums').jjCookieDelete();
    jj('account_factor_comment').jjCookieDelete();
    jj('account_factor_comment1').jjCookieDelete();
    jj('account_factor_comment2').jjCookieDelete();
    jj('account_factor_comment3').jjCookieDelete();
    jj('account_factor_comment4').jjCookieDelete();
}
function loadOrderForm() {
    $("#sw").load("formCms/order_form.html", null, function () {
        $("#insert_order").click(function () {
            if ($("#enrolment_val01").val() == "") {
                $("#enrolment_val01").css("border", "0.5px red dashed");
                new jj("لطفا تمام فیلدهای ضروری را پر کنید").jjDialog();
            } else if ($("#enrolment_val02").val() == "") {
                $("#enrolment_val01").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val02").css("border", "0.5px red dashed");
                new jj("لطفا تمام فیلدهای ضروری را پر کنید").jjDialog();
            } else if ($("#enrolment_val03").val() == "") {
                $("#enrolment_val01").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val02").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val03").css("border", "0.5px red dashed");
                new jj("لطفا تمام فیلدهای ضروری را پر کنید").jjDialog();

            } else if ($("#enrolment_val04").val() == "") {
                $("#enrolment_val01").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val02").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val03").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val04").css("border", "0.5px red dashed");
                new jj("لطفا تمام فیلدهای ضروری را پر کنید").jjDialog();

            } else if ($("#enrolment_val05").val() == "") {
                $("#enrolment_val01").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val02").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val03").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val04").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val05").css("border", "0.5px red dashed");
                new jj("لطفا تمام فیلدهای ضروری را پر کنید").jjDialog();

            } else if ($("#enrolment_val06").val() == "") {
                $("#enrolment_val01").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val02").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val03").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val04").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val05").css("border", "0.5px rgb(226, 227, 226) solid");
                $("#enrolment_val06").css("border", "0.5px red dashed");
                new jj("لطفا تمام فیلدهای ضروری را پر کنید").jjDialog();

            } else {
                new jj("do=Enrolment.insert&" + new jj("#orderForm").jjSerial()).jjAjax2(true);
                new jj('productNums').jjCookieDelete();
                new jj('productsId').jjCookieDelete();
                $("#productNums").html(0);
                sw(setting_default_sw);
            }
        });
    });
////        if ($('#orderFormDiv').length == 0) {
//        $("body").append("<div id='orderFormDiv'></div>");
//        $("#orderFormDiv").load("order_form.html", null, function () {
//            $('#orderBtn').button().click(function () {
//                alert(1);
//            });
//            $("#orderForm").dialog({
//                autoOpen: false,
//                height: 450,
//                width: 790,
//                modal: true,
//                title: "ثبت سفارش",
//                buttons: {
//                    "لغو": function () {
//                        $(this).dialog("close");
//                    }
//                },
//                close: function () {
//                    $(this).dialog('destroy');
//                }
//            });
//            $("#orderForm").dialog("open");
//            return false;
//        });
////    }
}
function Comment() {
    if ($('#comment_full_name').val() == '') {
        $('#comment_full_name').css("border", "red dashed");
    } else if ($('#comment_email').val() == '') {
        $('#comment_full_name').css("border", "none"); //if previus time was red and know intered
        $('#comment_email').css("border", "red dashed");
    } else if ($('#comment_text').val() == '') {
        $('#comment_email').css("border", "none"); //if previus time was red and know intered
        $('#comment_text').css("border", "red dashed");
    } else {
        jj("do=Comment.insert&" + new jj("#commentForm").jjSerial()).jjAjax2();
        sw(setting_default_sw);//برای نمایش صفحه اصلی بعد از ارسال فرم
    }
}
;
//<============ BY RASHIDI ========

//====================================mirhaj
function Save() {
    alert(new jj("#enrolment1Form").jjSerial());
    jj("do=Enrolment.insert&" + new jj("#enrolment1Form").jjSerial()).jjAjax2();
}
;
//==================================>mirhaj
function swNews(newsId) {
    if (jj(newsId).jjIsDigit()) {
        new jj("do=News.sw&id=" + newsId.toString() + "&panel=sw").jjAjax2(true);
        //        $('#sliderPanel').hide();
        //        $('#bodyPanel').show();
        //        $('#sw').show();
        //        swTab(3);

    }
}
;
//============ BY RASHIDI ========>
function swProduct(productId) {
    if (jj(productId).jjIsDigit()) {
//        new jj("do=Product.sw&id=" + productId.toString() + "&panel=swTitle").jjAjax2(true);
        new jj("do=Product.getOneProduct&id=" + productId.toString() + "&panel=sw").jjAjax2(true);
        //        $('#sliderPanel').hide();
        //        $('#bodyPanel').show();
        //        $('#sw').show();
        //        swTab(3);

    }
}
;
//<============ BY RASHIDI ========
/*
 *Only use when div whit "id=swTopNewsDiv" is avalable in DOM( when getList() in serverside has ben caled)
 **/
function getOneNews(newsId) {
    if (jj(newsId).jjIsDigit()) {
        new jj("do=News.getOneNews&id=" + newsId.toString() + "&panel=sw&jj=1&title=swTitle").jjAjax2(true);
        //        $('#sliderPanel').hide();
        //        $('#bodyPanel').show();
        //        $('#sw').show();
        //        swTab(3);

    }
}
;
function swNews2(newsId) {
    if (jj(newsId).jjIsDigit()) {
        new jj("do=News.swPishro&id=" + newsId.toString() + "&panel=sw").jjAjax2(true);
        //        $('#sliderPanel').hide();
        //        $('#bodyPanel').show();
        //        $('#sw').show();
        //        swTab(5);

    }
}
;
function swForum(forumId) {
    if (jj(forumId).jjIsDigit()) {
        new jj("do=Forum.getList&id=" + forumId.toString() + "&panel=sw").jjAjax2(true);
    }
}
;
function swPic(titleTextOrId) {
    var panelSelector = "sw";
    if (jj(titleTextOrId).jjIsDigit()) {
        new jj("do=Pic.getGallery&id=" + titleTextOrId.toString() + "&panel=" + panelSelector + "&title=swTitle").jjAjax2(true);
//        new jj("do=Pic.select&id=" + titleTextOrId.toString() + "&panel=" + panelSelector + "&title=swTitle").jjAjax2(true);
    } else {
        var text = (titleTextOrId == null) ? "جاوارا" : new jj(titleTextOrId.toString()).jjTrim();
        while (text.indexOf("\n") > -1) {
            text = text.replace("\n", "");
        }
        new jj("do=Pic.sw&text=" + text + "&panel=" + panelSelector + "&title=swTitle").jjAjax2(true);
    }
}
;
function searchAction(text, panelSelector) {
    if (text.length < 2) {
        return;
    }
    panelSelector = (panelSelector == null) ? "sw" : panelSelector;
    new jj("do=Content.searchTextInAll&text=" + text + "&panel=" + panelSelector + "&title=swTitle").jjAjax2(true);
}
/**
 * This method don't lets to user write string on TextField <br>
 * @param selector is TextFeildTagID selector; <br/>
 * @param maxLength is int (default: 10) <br/>
 */
function search(searchtxtSelector) {
    if (LANGUAGE == 'fa') {
        jj(searchtxtSelector).jjSetDefaultValueToTxt("");
    } else {
        jj(searchtxtSelector).jjSetDefaultValueToTxt("Search...");
    }
    var panelSelector = (panelSelector == null) ? "sw" : panelSelector;
    $(searchtxtSelector).keypress(function (event) {
        var keynum;
        if (window.event) { // IE
            keynum = event.keyCode
        } else if (event.which) { // Netscape/Firefox/Opera
            keynum = event.which
        }
        if (keynum == undefined) {
            event.returnValue = true;
            return true;
        } else {
            if (keynum == 13) {
                var text = new jj(searchtxtSelector).jjVal();
                if (text.length > 2) {
                    searchproduct();
                }
                event.returnValue = true;
                return true;
            }
        }
    })
}

function newsSlider2(panel) {//static fixed absolute inherit relative
    var panelWidth = $(panel).css('width');
    var panelHeight = $(panel).css('height');
    if ($(panel).css('direction') != 'ltr') {
        alert("div by id=" + panel + " must be direction:ltr ")
    }
    var param = "";
    param += "do=News.getSlider2";
    param += "&panel=" + panel.replace("#", "");
    param += "&width=" + (panelWidth != null ? panelWidth : 600);
    param += "&height=" + (panelHeight != null ? panelHeight : 300);
    new jj(param).jjAjax2();
}

/**
 * اسلایدر بوت استرپ
 * @param {type} panel
 * @returns {undefined}
 */
function getSlickSliderNews(panel) {//static fixed absolute inherit relative
    var pannelDiv = (panel) ? panel : "swNewsSlider";
    new jj("do=News.getSlickSlider&panel=" + pannelDiv + "&jj=1").jjAjax2(true);
}

var runNewsSlickSlider = function () {
    $('.newsSlickSlider').slick({
        dots: true,
        rtl: true,
        infinite: true,
        speed: 500,
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 2000,
        arrows: true,
        responsive: [{
                breakpoint: 600,
                settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                }
            },
            {
                breakpoint: 400,
                settings: {
                    arrows: false,
                    slidesToShow: 1,
                    slidesToScroll: 1
                }
            }]
    });
};
//============ BY RASHIDI ========>
function productSlider2(panel) {//static fixed absolute inherit relative
    var panelWidth = $(panel).css('width');
    var panelHeight = $(panel).css('height');
    if ($(panel).css('direction') != 'ltr') {
        alert("div by id=" + panel + " must be direction:ltr ")
    }
    var param = "";
    param += "do=Product.getSliderTazeha";
    param += "&panel=" + panel.replace("#", "");
    param += "&width=" + (panelWidth != null ? panelWidth : 600);
    param += "&height=" + (panelHeight != null ? panelHeight : 300);
    new jj(param).jjAjax2();
}
//<============ BY RASHIDI ========
function picSlider(panel, delay) {
    var panelWidth = $(panel).css('width');
    var panelHeight = $(panel).css('height');
    var param = "";
    param += "do=Pic.getPicSlider";
    param += "&panel=" + panel.replace("#", "");
    param += "&delay=" + delay;
    param += "&width=" + (panelWidth != null ? panelWidth : 600);
    param += "&height=" + (panelHeight != null ? panelHeight : 300);
    new jj(param).jjAjax2();
}
function picSlipprySlider(panel, delay) {
    var panelWidth = $(panel).css('width');
    var panelHeight = $(panel).css('height');
    var param = "";
    param += "do=Pic.getPicSlipprySlider";
    param += "&panel=" + panel.replace("#", "");
    param += "&delay=" + delay;
    param += "&width=" + (panelWidth != null ? panelWidth : 600);
    param += "&height=" + (panelHeight != null ? panelHeight : 300);
    new jj(param).jjAjax2();
}

function swAddForumCategory() {
    if (USER_NAME == '') {
        //        new jj('جهت افزودن یک بحث جدید احتیاج به لاگین و یا ثبت نام می باشد. آیا مایل باشید؟').jjDialog_YesNo("sw('$login');", true, 'نیاز به لاگین')
        sw('$login');
    } else {
        $("#sw").load("formCms/public_add_forum_cat.html", null, function () {
            $('#insert_ForumCat').button().click(function () {
                jj("do=Category_Forum.insertByUser&" + new jj("#swCategoryForumForm").jjSerial()).jjAjax2(false, 'Server');
                sw('$forum');
            });
            $('#Cansel_ForumCat').button().click(function () {
                sw('$forum');
            });
        });
    }
}
var swAddForumCommentCounter = 0;
function swAddForumComment(forum_cat_id) {
    if (USER_NAME == '') {
        //        new jj('جهت افزودن یک کامنت جدید احتیاج به لاگین و یا ثبت نام می باشد. آیا مایل باشید؟').jjDialog_YesNo("sw('$login');", true, 'نیاز به لاگین')
        sw('$login');
    } else {
        swAddForumCommentCounter += 1;
        $("#sw").load("formCms/public_add_forum_comment.html", null, function () {
            $('#forum_url_file').button().click(function () {
            });
            $('#upload_Forum').button().click(function () {
                if (new jj('#forum_url_file').jjVal() != '') {
                    $('#upload_Forum').hide();
                    $('#forum_url_file').hide();
                    $('#forum_url').show();
                }
            });
            $('#forum_url').button().click(function () {
                $('#upload_Forum').show();
                $('#forum_url_file').show();
                $('#forum_url').hide()
            });
            //    
            new jj("#upload_Forum").jjAjaxFileUpload2("#forum_url_file", "#forum_url");
            $('#forum_content').attr('id', 'forum_content' + swAddForumCommentCounter);
            forum_content_editor = new jj('#forum_content' + swAddForumCommentCounter).jjEditor();
            new jj(forum_content_editor).jjEditorVal("");
            $('#insert_Forum').button().click(function () {
                new jj('do=Forum.insertByUser&forum_creator=' + USER_ID + '&' + new jj('#swForumForm').jjSerial()
                        + '&forum_category_id=' + forum_cat_id).jjAjax2();
            });
            $('#cancel_Forum').button().click(function () {
                swGetForum(forum_cat_id)
            });
        });
        $("#swTitle").html("افزودن کامنت به انجمن");
    }
}

function swGetForum(forum_cat_id) {
    new jj("do=Forum.getList&id=" + forum_cat_id + "&panel=sw").jjAjax2(true);
}
function ForumForm_fa(forum_id) {
    $("#sw").html(getForumForm_fa(forum_id));
    $("#swTitle").html("افزودن کامنت");
}
function ForumCategoryForm_fa() {
    $("#sw").html(getForumCategoryForm_fa());
    $("#swTitle").html("افزودن انجمن (موضوع بحث)");
}
function swTab(tabId) {
    tabId = tabId == null ? 0 : tabId;
    for (var i = 0; i < 20; i++) {
        if ($("#ll" + i).hasClass("active")) {
            $("#ll" + i).removeClass("active")
        }
    }
    $("#ll" + tabId).addClass("active");
}
function vote(vote_id, check_id) {
    //    alert(vote_id +"-"+check_id);
    //    document.write(vote_id +"-"+check_id);
    if (new jj("#vote-" + vote_id + "-" + check_id).jjVal() == 1) {
        $("#vote-" + vote_id + "-1").hide();
        $("#vote-" + vote_id + "-2").hide();
        $("#vote-" + vote_id + "-3").hide();
        $("#vote-" + vote_id + "-4").hide();
        $("#vote-" + vote_id + "-5").hide();
        $("#vote-" + vote_id + "-6").hide();
        new jj("do=Category_Poll.insert&category_poll_answer=" + check_id + "&category_poll_user_id=1&category_poll_which=" + vote_id).jjAjax2();
    }
    //    alert(new jj("#poll"+vote_id).jjSerial());
    //    alert(new jj("#gr1").jjVal());
    //    alert(new jj("#GroupRadio"+vote_id).jjSerial());
    //    alert(new jj("#poll"+vote_id).jjSerial());
    $('#vote-' + vote_id + '-1').hide();
    $('#vote-' + vote_id + '-2').hide();
    $('#vote-' + vote_id + '-3').hide();
    $('#vote-' + vote_id + '-4').hide();
    $('#vote-' + vote_id + '-5').hide();
    $('#vote-' + vote_id + '-6').hide();
    new jj("vote").jjCookieSave('#vote-' + vote_id + '-1___' + '#vote-' + vote_id + '-2___' + '#vote-' + vote_id + '-3___' + '#vote-' + vote_id + '-4___' + '#vote-' + vote_id + '-5___' + '#vote-' + vote_id + '-6___');
}
//
/* Accordion Menu v2013.3.18. Copyright www.menucool.com */
function toggleList(id) {
    if ($("#uperNodeDiv" + id).hasClass("closedList")) {
        $("#uperNodeDiv" + id).removeClass("closedList");
        $("#uperNodeDiv" + id).addClass("openedList");
    } else if ($("#uperNodeDiv" + id).hasClass("openedList")) {
        $("#uperNodeDiv" + id).removeClass("openedList");
        $("#uperNodeDiv" + id).addClass("closedList");
    }
}
//############## Portal ########################################################
function addNewPortalPost(portalId) {
    portalPostLoadForm();
    loadPortalPostforEdit(portalId);
}
function PortalUserLogin(portalId) {
    if (new jj('#portal_user_UserName').jjVal() == '') {
        $("#portal_user_UserName").css("border", "red dashed");
        $("#loginMessagePanel").html("ایمیل یا رمز عبور نباید تهی باشد.");
        return false;
    } else if (new jj('#portal_user_pass').jjVal() == '') {
        $("#portal_user_UserName").css("border", "none");
        $("#portal_user_pass").css("border", "red dashed");
        $("#loginMessagePanel").html("ایمیل یا رمز عبور نباید تهی باشد.");
        return false;
    }
    $("#portal_user_UserName").css("border", "none");
    $("#portal_user_pass").css("border", "none");
    jj("do=Access_User.loginPortalUser&panel=" + setting_login_exit_panel.replace("#", "") + "&id=" + portalId + "&" + new jj("#loginForm").jjSerial()).jjAjax2(false);
}

function loadPortalPostforEdit(portalId) {//load list of all posts whit edit btn
    portalPostLoadForm();
    new jj("do=Portal.loadPortalPostforEdit&id=" + portalId + "&panel=swLeft&jj=1").jjAjax2(true);
}
// Portal and portalUsers
function swGetPortalPost(postId) {
    alert("swGetPortalPost([postId])");
    if (jj(postId).jjIsDigit()) {
        new jj("do=Portal.getPortalPost&id=" + postId.toString() + "&panel=sw&jj=1").jjAjax2(true);
        //        $('#sliderPanel').hide();
        //        $('#bodyPanel').show();
        //        $('#sw').show();
        //        swTab(3);
    }
}

function insertPostByUserPortal() {
    var param = "";
    param += "do=Portal.insertByPortalUser";
    param += "&" + new jj("#newPostForm").jjSerial(); //#newPostForm is if post_form.html
    jj(param).jjAjax2(false);
    portalFormClean();
}
function editPostByUserPortal(postId) {
    var param = "";
    param += "do=Portal.editPostByUserPortal";
    param += "&" + new jj("#newPostForm").jjSerial(); //#newPostForm is if post_form.html
    jj(param).jjAjax2(false);
    portalFormClose();
}
function deleteByPortalUser(postId) {
    var param = "";
    param += "do=Portal.deleteByPortalUser";
    param += "&id=" + postId;
    jj(param).jjAjax2(false);
    $("#swForm").hide('slow', function () {
        portalFormClean();
    });
}
function selectPostforEdit(postId) {
    portalPostLoadForm();
    var param = "";
    param += "do=Portal.selectPostforEdit";
    param += "&id=" + postId;
    jj(param).jjAjax2(false);
}

function portalFormClose() {
    $("#swForm").html("");
}
function portalFormClean() {
    new jj("#newPostForm").jjFormClean();
    $("#preview_portalPost_pic1").attr('src', "img/preview.jpg");
    $("#preview_portalPost_pic2").attr('src', "img/preview.jpg");
    $("#preview_portalPost_pic3").attr('src', "img/preview.jpg");
    $("#preview_portalPost_pic4").attr('src', "img/preview.jpg");
    $("#preview_portalPost_pic5").attr('src', "img/preview.jpg");
//در اینجا می شود اگر عکسی آپلود کرده بود را پاک کرد
//        new jj("#"+cmsPortal.f_gallery_id_select).jjVal('1');
//        new jj("#"+cmsPortal.f_lang).jjVal('1');
//        new jj("#"+cmsPortal.f_parent).jjVal('0');
//        $("#pic_pic_name_preview").attr('src','img/preview.jpg');
}

function cleanFormAfterEdit(portalid) {
    $("#swForm").html() != "";
    portalPostLoadForm();
    loadPortalPostforEdit(portalid);
}
function portalPostLoadForm() {
    if (($("#swForm").html() != "")) {
        $("#swForm").show();
        portalFormClean();
    } else {
        $("#swForm").load("images_takrod/post_form.html", null, function () {
            PortalFormGetValuesList();
            portalFormClean();
            $('#btnChangeValueComponent1').click(function () {
                if ($('#portal_post_val11').css('display') == 'none') {
                    $('#portal_post_val11').show();
                    $('#portal_post_val11').attr('name', 'portal_post_val1');
                    $('#portal_post_val1').hide();
                    $('#portal_post_val1').attr('name', 'aaa');
                    $('#btnChangeValueComponent1').val("*");
                } else {
                    $('#portal_post_val11').hide();
                    $('#portal_post_val11').attr('name', 'aaa');
                    $('#portal_post_val1').show();
                    $('#portal_post_val1').attr('name', 'portal_post_val1');
                    $('#btnChangeValueComponent1').val("+");
                }
            })

            $('#btnChangeValueComponent2').click(function () {
                if ($('#portal_post_val22').css('display') == 'none') {
                    $('#portal_post_val22').show();
                    $('#portal_post_val22').attr('name', 'portal_post_val2');
                    $('#portal_post_val2').hide();
                    $('#portal_post_val2').attr('name', 'aaa');
                    $('#btnChangeValueComponent2').val("*");
                } else {
                    $('#portal_post_val22').hide();
                    $('#portal_post_val22').attr('name', 'aaa');
                    $('#portal_post_val2').show();
                    $('#portal_post_val2').attr('name', 'portal_post_val2');
                    $('#btnChangeValueComponent2').val("+");
                }
            })

            $('#btnChangeValueComponent3').click(function () {
                if ($('#portal_post_val33').css('display') == 'none') {
                    $('#portal_post_val33').show();
                    $('#portal_post_val33').attr('name', 'portal_post_val3');
                    $('#portal_post_val3').hide();
                    $('#portal_post_val3').attr('name', 'aaa');
                    $('#btnChangeValueComponent3').val("*");
                } else {
                    $('#portal_post_val33').hide();
                    $('#portal_post_val33').attr('name', 'aaa');
                    $('#portal_post_val3').show();
                    $('#portal_post_val3').attr('name', 'portal_post_val3');
                    $('#btnChangeValueComponent3').val("+");
                }
            })

            $('#btnChangeValueComponent4').click(function () {
                if ($('#portal_post_val44').css('display') == 'none') {
                    $('#portal_post_val44').show();
                    $('#portal_post_val44').attr('name', 'portal_post_val4');
                    $('#portal_post_val4').hide();
                    $('#portal_post_val4').attr('name', 'aaa');
                    $('#btnChangeValueComponent4').val("*");
                } else {
                    $('#portal_post_val44').hide();
                    $('#portal_post_val44').attr('name', 'aaa');
                    $('#portal_post_val4').show();
                    $('#portal_post_val4').attr('name', 'portal_post_val4');
                    $('#btnChangeValueComponent4').val("+");
                }
            })

            $('#btnChangeValueComponent5').click(function () {
                if ($('#portal_post_val55').css('display') == 'none') {
                    $('#portal_post_val55').show();
                    $('#portal_post_val55').attr('name', 'portal_post_val5');
                    $('#portal_post_val5').hide();
                    $('#portal_post_val5').attr('name', 'aaa');
                    $('#btnChangeValueComponent5').val("*");
                } else {
                    $('#portal_post_val55').hide();
                    $('#portal_post_val55').attr('name', 'aaa');
                    $('#portal_post_val5').show();
                    $('#portal_post_val5').attr('name', 'portal_post_val5');
                    $('#btnChangeValueComponent5').val("+");
                }
            })

            $('#btnChangeValueComponent6').click(function () {
                if ($('#portal_post_val66').css('display') == 'none') {
                    $('#portal_post_val66').show();
                    $('#portal_post_val66').attr('name', 'portal_post_val6');
                    $('#portal_post_val6').hide();
                    $('#portal_post_val6').attr('name', 'aaa');
                    $('#btnChangeValueComponent6').val("*");
                } else {
                    $('#portal_post_val66').hide();
                    $('#portal_post_val6').attr('name', 'aaa');
                    $('#portal_post_val6').show();
                    $('#portal_post_val6').attr('name', 'portal_post_val6');
                    $('#btnChangeValueComponent6').val("+");
                }
            })

            $('#btnChangeValueComponent7').click(function () {
                if ($('#portal_post_val77').css('display') == 'none') {
                    $('#portal_post_val77').show();
                    $('#portal_post_val77').attr('name', 'portal_post_val7');
                    $('#portal_post_val7').hide();
                    $('#portal_post_val7').attr('name', 'aaa');
                    $('#btnChangeValueComponent7').val("*");
                } else {
                    $('#portal_post_val77').hide();
                    $('#portal_post_val77').attr('name', 'aaa');
                    $('#portal_post_val7').show();
                    $('#portal_post_val7').attr('name', 'portal_post_val7');
                    $('#btnChangeValueComponent7').val("+");
                }
            })
            $('#btnChangeValueComponent8').click(function () {
                if ($('#portal_post_val88').css('display') == 'none') {
                    $('#portal_post_val88').show();
                    $('#portal_post_val88').attr('name', 'portal_post_val8');
                    $('#portal_post_val8').hide();
                    $('#portal_post_val8').attr('name', 'aaa');
                    $('#btnChangeValueComponent8').val("*");
                } else {
                    $('#portal_post_val88').hide();
                    $('#portal_post_val88').attr('name', 'aaa');
                    $('#portal_post_val8').show();
                    $('#portal_post_val8').attr('name', 'portal_post_val8');
                    $('#btnChangeValueComponent8').val("+");
                }
            })
            $('#btnChangeValueComponent9').click(function () {
                if ($('#portal_post_val99').css('display') == 'none') {
                    $('#portal_post_val99').show();
                    $('#portal_post_val99').attr('name', 'portal_post_val9');
                    $('#portal_post_val9').hide();
                    $('#portal_post_val9').attr('name', 'aaa');
                    $('#btnChangeValueComponent9').val("*");
                } else {
                    $('#portal_post_val99').hide();
                    $('#portal_post_val99').attr('name', 'aaa');
                    $('#portal_post_val9').show();
                    $('#portal_post_val9').attr('name', 'portal_post_val9');
                    $('#btnChangeValueComponent9').val("+");
                }
            })
            $('#btnChangeValueComponent10').click(function () {
                if ($('#portal_post_val1010').css('display') == 'none') {
                    $('#portal_post_val1010').show();
                    $('#portal_post_val1010').attr('name', 'portal_post_val10');
                    $('#portal_post_val10').hide();
                    $('#portal_post_val10').attr('name', 'aaa');
                    $('#btnChangeValueComponent10').val("*");
                } else {
                    $('#portal_post_val1010').hide();
                    $('#portal_post_val1010').attr('name', 'aaa');
                    $('#portal_post_val10').show();
                    $('#portal_post_val10').attr('name', 'portal_post_val10');
                    $('#btnChangeValueComponent10').val("+");
                }
            });
//              <================= mirhaj-->
            $('#btnChangeValueComponent01').click(function () {
                if ($('#portal_post_prop11').css('display') == 'none') {
                    $('#portal_post_prop11').show();
                    $('#portal_post_prop11').attr('name', 'portal_post_prop1');
                    $('#portal_post_prop1').hide();
                    $('#portal_post_prop1').attr('name', 'aaa');
                    $('#btnChangeValueComponent01').val("*");
                } else {
                    $('#portal_post_prop11').hide();
                    $('#portal_post_prop11').attr('name', 'aaa');
                    $('#portal_post_prop1').show();
                    $('#portal_post_prop1').attr('name', 'portal_post_prop1');
                    $('#btnChangeValueComponent01').val("+");
                }
            });
            $('#btnChangeValueComponent02').click(function () {
                if ($('#portal_post_prop22').css('display') == 'none') {
                    $('#portal_post_prop22').show();
                    $('#portal_post_prop22').attr('name', 'portal_post_prop2');
                    $('#portal_post_prop2').hide();
                    $('#portal_post_prop2').attr('name', 'aaa');
                    $('#btnChangeValueComponent02').val("*");
                } else {
                    $('#portal_post_prop22').hide();
                    $('#portal_post_prop22').attr('name', 'aaa');
                    $('#portal_post_prop2').show();
                    $('#portal_post_prop2').attr('name', 'portal_post_prop2');
                    $('#btnChangeValueComponent02').val("+");
                }
            });
            $('#btnChangeValueComponent03').click(function () {
                if ($('#portal_post_prop33').css('display') == 'none') {
                    $('#portal_post_prop33').show();
                    $('#portal_post_prop33').attr('name', 'portal_post_prop3');
                    $('#portal_post_prop3').hide();
                    $('#portal_post_prop3').attr('name', 'aaa');
                    $('#btnChangeValueComponent03').val("*");
                } else {
                    $('#portal_post_prop33').hide();
                    $('#portal_post_prop33').attr('name', 'aaa');
                    $('#portal_post_prop3').show();
                    $('#portal_post_prop3').attr('name', 'portal_post_prop3');
                    $('#btnChangeValueComponent03').val("+");
                }
            });
            $('#btnChangeValueComponent04').click(function () {
                if ($('#portal_post_prop44').css('display') == 'none') {
                    $('#portal_post_prop44').show();
                    $('#portal_post_prop44').attr('name', 'portal_post_prop4');
                    $('#portal_post_prop4').hide();
                    $('#portal_post_prop4').attr('name', 'aaa');
                    $('#btnChangeValueComponent04').val("*");
                } else {
                    $('#portal_post_prop44').hide();
                    $('#portal_post_prop44').attr('name', 'aaa');
                    $('#portal_post_prop4').show();
                    $('#portal_post_prop4').attr('name', 'portal_post_prop4');
                    $('#btnChangeValueComponent04').val("+");
                }
            });
            $('#btnChangeValueComponent05').click(function () {
                if ($('#portal_post_prop55').css('display') == 'none') {
                    $('#portal_post_prop55').show();
                    $('#portal_post_prop55').attr('name', 'portal_post_prop5');
                    $('#portal_post_prop5').hide();
                    $('#portal_post_prop5').attr('name', 'aaa');
                    $('#btnChangeValueComponent05').val("*");
                } else {
                    $('#portal_post_prop55').hide();
                    $('#portal_post_prop55').attr('name', 'aaa');
                    $('#portal_post_prop5').show();
                    $('#portal_post_prop5').attr('name', 'portal_post_prop5');
                    $('#btnChangeValueComponent05').val("+");
                }
            });
//                =================> mirhaj-->
            //Upload bottons ==>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            new jj('#upload_btn_portalPost_pic1').jjAjaxFileUpload('upload_portalPost_pic1', '#portal_post_pic1', '#preview_portalPost_pic1');
            $('#portal_post_pic1').keyup(function () {
                $('#preview_portalPost_pic1').attr('src', 'upload/' + $('#portal_post_pic1').val());
                if ($('#portal_post_pic1').val() == '') {
                    $('#preview_portalPost_pic1').attr('src', 'img/preview.jpg');
                }
            });
            new jj('#upload_btn_portalPost_pic2').jjAjaxFileUpload('upload_portalPost_pic2', '#portal_post_pic2', '#preview_portalPost_pic2');
            $('#portal_post_pic2').keyup(function () {
                $('#preview_portalPost_pic2').attr('src', 'upload/' + $('#portal_post_pic2').val());
                if ($('#portal_post_pic2').val() == '') {
                    $('#preview_portalPost_pic2').attr('src', 'img/preview.jpg');
                }
            });
            new jj('#upload_btn_portalPost_pic3').jjAjaxFileUpload('upload_portalPost_pic3', '#portal_post_pic3', '#preview_portalPost_pic3');
            $('#portal_post_pic3').keyup(function () {
                $('#preview_portalPost_pic3').attr('src', 'upload/' + $('#portal_post_pic3').val());
                if ($('#portal_post_pic3').val() == '') {
                    $('#preview_portalPost_pic3').attr('src', 'img/preview.jpg');
                }
            });
            new jj('#upload_btn_portalPost_pic4').jjAjaxFileUpload('upload_portalPost_pic4', '#portal_post_pic4', '#preview_portalPost_pic4');
            $('#portal_post_pic4').keyup(function () {
                $('#preview_portalPost_pic4').attr('src', 'upload/' + $('#portal_post_pic4').val());
                if ($('#portal_post_pic4').val() == '') {
                    $('#preview_portalPost_pic4').attr('src', 'img/preview.jpg');
                }
            });
            new jj('#upload_btn_portalPost_pic5').jjAjaxFileUpload('upload_portalPost_pic5', '#portal_post_pic5', '#preview_portalPost_pic5');
            $('#portal_post_pic5').keyup(function () {
                $('#preview_portalPost_pic5').attr('src', 'upload/' + $('#portal_post_pic5').val());
                if ($('#portal_post_pic5').val() == '') {
                    $('#preview_portalPost_pic5').attr('src', 'img/preview.jpg');
                }
            });
            //Upload bottons <<<<<<<<<<<<<<<<<<<<<<=========
            new jj("do=Portal.add_new_InPortal").jjAjax2(false);
            //cancel btm===>>>>
            $("#portalPost_cancelBtn").click(function () {
                $("#swForm").hide('slow', function () {
                    portalFormClean();
                });
            });
        }
        )
    }
    ;
    function PortalFormGetValuesList(id) {
        PortalFormGetVal1List(id);
        PortalFormGetVal2List(id);
        PortalFormGetVal3List(id);
        PortalFormGetVal4List(id);
        PortalFormGetVal5List(id);
//       <================= mirhaj-->
        PortalFormGetProp1List(id);
        PortalFormGetProp2List(id);
        PortalFormGetProp3List(id);
        PortalFormGetProp4List(id);
        PortalFormGetProp5List(id);
//     =================> mirhaj-->
    }
    function PortalFormGetVal1List(id) {
        var param = "";
        param += "do=Portal.get_val1List";
        param += "&panel=" + "portal_post_val1";
        param += "&selected=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
    }
    function PortalFormGetVal2List(id) {
        var param = "";
        param += "do=Portal.get_val2List";
        param += "&panel=" + "portal_post_val2";
        param += "&selected=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
    }
    function PortalFormGetVal3List(id) {
        var param = "";
        param += "do=Portal.get_val3List";
        param += "&panel=" + "portal_post_val3";
        param += "&selected=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
    }
    function PortalFormGetVal4List(id) {
        var param = "";
        param += "do=Portal.get_val4List";
        param += "&panel=" + "portal_post_val4";
        param += "&selected=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
    }
    function PortalFormGetVal5List(id) {
        var param = "";
        param += "do=Portal.get_val5List";
        param += "&panel=" + "portal_post_val5";
        param += "&selected=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
    }
//       <================= mirhaj-->
    function PortalFormGetProp1List(id) {
        var param = "";
        param += "do=Portal.get_prop1List";
        param += "&panel=" + "portal_post_prop1";
        param += "&selected=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
    }
    function PortalFormGetProp2List(id) {
        var param = "";
        param += "do=Portal.get_prop2List";
        param += "&panel=" + "portal_post_prop2";
        param += "&selected=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
    }

    function PortalFormGetProp3List(id) {
        var param = "";
        param += "do=Portal.get_prop1List";
        param += "&panel=" + "portal_post_prop3";
        param += "&selected=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
    }
    function PortalFormGetProp4List(id) {
        var param = "";
        param += "do=Portal.get_prop4List";
        param += "&panel=" + "portal_post_prop4";
        param += "&selected=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
    }
    function PortalFormGetProp5List(id) {
        var param = "";
        param += "do=Portal.get_prop5List";
        param += "&panel=" + "portal_post_prop5";
        param += "&selected=" + (id == null ? "" : id);
        jj(param).jjAjax2(false);
    }
//    =================> mirhaj-->
}



// 
function tblMethod(tblCode) {

    if (tblCode == "102") {

        add_new();
    } else if (tblCode == "105") {

        add_newAzayeKargrouh();
    }
    function add_new() {
//        jj("do=Access_User.add_new").jjAjax2(false);
//        $("#payamHayeManTbl").hide();
//        $("#etelatshakhs").hide();
//        $("#axplus").hide();
//checkFrestandeAndEmail
//        $("#girandeErsal").show();
//        $("#email").show();
//        $("#checkFrestandeAndEmail").show();
        $("#frestande").hide();
        $("#cancel_bazgashteErsali").hide();
        $("#CancelPayamhaDarkhast").hide();
        $("#girandeyepayam").show();
//        $("#girandeErsal").show();
        $('#payamHayeMansw').show();
//        $('#girandeyepayam').show();
        $('#payam').show();
//        $('#email').show();
//        $('#paygham').hide();

        $('#payamHayeManForm').show();
        $('#sendpayam').show();
        $("#sendpasokh").hide();
//        $('#frestande').hide();
////        $('#cancel_Darkhastha').show();
//        $('#swDarkhasthaForm').hide();
//        $('#darkhasthaForm').hide();
//        $('#payamhayeDaryafti').hide();
//        $('#payamhayeErsali').hide();
        $('#PayamhayeErsaliMan').hide();
//        $('#PayamhayeDaryahftiMan').hide();
        $('#cancel_payamPasokh').hide();
        $('#cancel_payamJaded').show();

        m_cleanDarkhastha();

//        pmsDarkhastDavaran.m_cleanDarkhastha();
    }
    ;

    function add_newAzayeKargrouh() {
        $("#sabtenameSarye").show();
        var param = "";
//    param += "&selectKargroh=" + new jj("#selectKargrohha option").jjVal();
//    param += "&parametrNoe1=" + new jj("#noeAzmonSelectOption").jjVal();
        param += "&do=DarkhasthayeErjaeshodebeSarparastKargroh.actionSelectKargrouha";
        jj(param).jjAjax2(false);




    }



//    else if (tblCode == "15") {
//        cmsUser.m_add_new();
//    }
//    else if (tblCode == "25") {
//        cmsEmail.m_add_new();
// 
//    else if (tblCode == "23") {
//        cmsSettingSMS.m_add_new();
//    }

}

//       $("#loginForm").click(function () {
//           
//             var param = "";
//        param += "do=Darkhastha.insertByUser";
//        param += "&" + new jj("#swDarkhasthaForm").jjSerial();
//             jj(param).jjAjax2(false);
////        $('#swDarkhasthaForm').();
////      $('#save_Darkhastha').hide();
////       $('#cancel_Darkhastha').hide();
////        cmsPayamha.tabSizeForm();
//       });
//       $("#darkhastjaded").click(function () {
//           alert("ok");
//       });
function selectPayamhaFromUser(id) {
    reportStatus();
    var param = "";
    param += "do=Payamha.selectPayamhaFromUser";
    param += "&id" + "=" + (id == null ? "" : id);

    showformPayam();

    jj(param).jjAjax2(false);
    $("#namegirandePasokh").hide();
    $("#payamha_title2").val('');
    $("#payamha_text2").val('');
    $("#girandeErsal").hide();
    $("#girandeyepayam").show();
//    showformbarayelaghvePayam();

}
function selectPayamhaFromUserErsali(id) {
    reportStatus();
    var param = "";
    param += "do=Payamha.selectPayamhaFromUser";
    param += "&id" + "=" + (id == null ? "" : id);

    $("#payamHayeManTbl").hide();
    $("#cancel_bazgashteErsali").show();
    $("#payam").show();
    $("#etelatshakhs").hide();
    $("#axplus").hide();
//     $("#payamha_frestande").show();
    $("#sendpasokh").hide();
    $('#sendpayam').hide();
    $("#frestande").show();
    $("#girandeyepayam").hide();
    $('#paygham').show();
    $('#payamHayeManForm').show();
    $('#swDarkhasthaForm').hide();
    $('#PayamhayeDaryahftiMan').hide();
    $('#PayamhayeErsaliMan').hide();
    $('#payamhayeDaryafti').show();
    $('#payamhayeErsali').show();
    $('#cancel_SavabegheDarkhast').hide();
    $('#cancel_payamJaded').hide();
    $('#cancel_payamPasokh').hide();


    jj(param).jjAjax2(false);
    $("#namegirandePasokh").hide();
    $("#girandeErsal").hide();
//    showformbarayelaghvePayam();

}
function selectSavabegheDarkhast(id) {
    m_cleanDarkhastha();
    reportStatus();
    var param = "";
    param += "do=Darkhastha.selectSavabegheDarkhast";
    param += "&id" + "=" + (id == null ? "" : id);
    $("#titredarkhastselect").show();

    $("#fileha").show();
    $("#DavaranPishnahadi").hide();
    $('#edameAzFormDarkhatha').show();
    $("#nevisandegan").hide();
    $(".inputSelectorDiv").html("");
    $("#filehaSabteNahaei").show();
//     if($("#darkhastha_file_name").val()==""){
//           $("#downloadefileketab").hide();
//     }else{
//     
//    $("#downloadefileketab").show();
//}
//     if($("#darkhastha_ax_name").val()==""){
//           $("#downloadaxjeld").hide();
//     }else{
//     
//    $("#downloadaxjeld").show();
//}
//    $("#sendAx").show();


    $("#darkhasthaForm").show();// اگر قبلا نمایش داده نشده باشد الان نمایش داده بشود
    $("#darkhasthaFormAfterSabteNahaei").hide();// اگر قبلا نمایش داده نشده باشد الان نمایش داده بشود
    $("#filehaAfterSabteNahaei").hide();// اگر قبلا نمایش داده نشده باشد الان نمایش داده بشود

    $("#EditDiv").show();

    showformDarkhast();
    jj(param).jjAjax2(false);
}
function selectAfterSabteNahaie(id) {
    m_cleanDarkhastha();
    reportStatus();
    var param = "";
    param += "do=Darkhastha.selectAfterSabteNahaie";
    param += "&id" + "=" + (id == null ? "" : id);
    $("#titredarkhastselect").hide();
    $("#darkhasthaForm").hide();// اگر قبلا نمایش داده نشده باشد الان نمایش داده بشود
    $("#darkhasthaFormAfterSabteNahaei").show();// اگر قبلا نمایش داده نشده باشد الان نمایش داده بشود
    $("#nevisandeganAfterSabteNahaei").hide();// اگر قبلا نمایش داده نشده باشد الان نمایش داده بشود
    $("#DavaranPishnahadiAfterSabteNahaei").hide();// اگر قبلا نمایش داده نشده باشد الان نمایش داده بشود
    $("#inputAfterSelectSabteNahaei").show();// اگر قبلا نمایش داده نشده باشد الان نمایش داده بشود
    $("#filehaSabteNahaei").hide();// اگر قبلا نمایش داده نشده باشد الان نمایش داده بشود
    $("#filehaAfterSabteNahaei").hide();// اگر قبلا نمایش داده نشده باشد الان نمایش داده بشود
    $("#PayamhayeInDarkhastAfterSabteNahaei").show();// اگر قبلا نمایش داده نشده باشد الان نمایش داده بشود
//    if($("#filehaAfterSabteNahaei").val("")){
//        $("#downloadefileketabAfterSabteNahaei").hide();
//    }
//    if($("#filehaAfterSabteNahaei").val("")){
//        $("#downloadefileketabAfterSabteNahaei").hide();
//    }
//    $("#sendKetab").hide();
//    $("#downloadefileketab").show();
//    $("#sendAx").hide();
//    $("#downloadaxjeld").show();
//    $("#EditDiv").show();

    showformDarkhast();
    jj(param).jjAjax2(false);
}
function selectDarkhastDavarFromUser(id) {
    reportStatus();
    m_cleanDarkhastha();
    var param = "";
    param += "do=DarkhastDavaran.selectDarkhastDavarFromUser";
    param += "&id" + "=" + (id == null ? "" : id);
    $("#darkhasthayeDavare").hide();
    $('#swDarkhasthaForm').show();
    $("#pms_darkhastdavaran_fille1").val('');
    $("#pms_darkhastdavaran_fille2").val('');
    $('#pms_darkhastdavaran_fille1').removeAttr('disabled', 'disabled');
    $('#pms_darkhastdavaran_fille2').removeAttr('disabled', 'disabled');
    $('#pms_darkhastdavaran_file2_file').show();
    $('#pms_darkhastdavaran_file1_file').show();
    $('#sendAx').show();
    $('#sendKetab').show();
    $('#matneba').show();
    $('#matnha2').show();
//     $('#swDarkhasthaForm').show();

//   sformDarkhast();
    jj(param).jjAjax2(false);
}
 function   m_remove(idUpload,id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('removeFile('+idUpload+','+id+');\n', true, "");

    }
  function  removeFile(idUpload,id) {
     
        var param = "";
        param += "do=Darkhastha.removeFile";
       
        param += "&upload_id=" +idUpload;
        param += "&id=" +id;
        new jj(param).jjAjax2(false);
//        pmsDarkhastha.m_show_tbl();
//        pmsDarkhastha.m_clean();
    }
function selectDarkhastDavarFromUserSabteNahaei(id) {
    reportStatus();
    m_cleanDarkhastha();
    var param = "";
    param += "do=DarkhastDavaran.selectDarkhastDavarFromUserSabteNahaei";
    param += "&id" + "=" + (id == null ? "" : id);
    $("#darkhasthayeDavare").hide();
    $("#bargozarifile").show();
    $('#swDarkhasthaForm').show();
    $('#pms_darkhastdavaran_file2_file').hide();
    $('#pms_darkhastdavaran_file1_file').hide();
    $('#pms_darkhastdavaran_fille1').attr('disabled', 'disabled');
    $('#pms_darkhastdavaran_fille2').attr('disabled', 'disabled');
    $('#sendAx').hide();
    $('#sendKetab').hide();
    $('#matneba').hide();
    $('#matnha2').hide();

//     $('#swDarkhasthaForm').show();

//    showformDarkhast();
    jj(param).jjAjax2(false);
}
function BazgashtDarkhastDavaran() {
    $("#darkhasthayeDavare").show();
    $('#swDarkhasthaForm').hide();
}
function selectPayamhayeinDarkhast(id) {
    var param = "";
    param += "do=Payamha.selectPayamhayeinDarkhast";
    param += "&id" + "=" + (id == null ? "" : id);
    $("#CancelPayamhaDarkhast").show();
    showPayamDarkhast();
    jj(param).jjAjax2(false);


}
function CancelPayamhaDarkhast() {
    $("#frestande").hide();
    recovery();
}
function etelaateShakhsi(id) {

    var param = "";
    param += "do=Access_User.etelaateShakhsi";
    param += "&id=" + id;
    $("#sendPic1").button().click(function () {
    });
    $("#upload_user_file1").button().click(function () {
    });
    new jj('#sendPic1').jjAjaxFileUpload('#upload_user_file1', '#user_pic1', '#userPicPreview1');
    $('#user_pic1').keyup(function () {
        $('#userPicPreview1').attr('src', 'upload/' + $('#user_pic1').val());
        if ($('#user_pic1').val() == '') {
            $('#userPicPreview1').attr('src', 'img/preview.jpg');
        }
    });
    $("#sendPic2").button().click(function () {
    });
    $("#upload_users_file1").button().click(function () {
    });
    new jj('#sendPic2').jjAjaxFileUpload('#upload_users_file1', '#user_pic2', '#usersPicPreview1');
    $('#user_pic2').keyup(function () {
        $('#usersPicPreview1').attr('src', 'upload/' + $('#user_pic2').val());
        if ($('#user_pic2').val() == '') {
            $('#usersPicPreview1').attr('src', 'img/preview.jpg');
        }
    });
//    param += "&" + new jj('#etelatefardi').jjSerial();
//  $(".first-content").css("height", "2343px");
    jj(param).jjAjax2(false);
//    $("#firstDiv").hide();
    $("#CancelPayamhaDarkhast").hide();
    $("#etelatshakhs").show();
    $("#titredarkhast").hide();
    $("#axplus").hide();
    $("#swDarkhasthaForm").hide();
    $("#cancel_bazgashteErsali").hide();
    $("#sendpayam").hide();
    $("#cancel_payamJaded").hide();

    $("#payamHayeManTbl").hide();
    $("#PayamhayeDaryahftiMan").hide();
    $("#PayamhayeErsaliMan").hide();
    $("#Information").hide();
    $("#darkhasthaForm").hide();
//
//     $("#payamHayeManTbl").hide();


    $("#sendpasokh").hide();
    $("#frestande").hide();
    $("#girandeyepayam").hide();

    $('#cancel_payamPasokh').hide();


}
function lagveEtelateShakhsi() {
    $("#etelatshakhs").hide();
//    $("#firstDiv").show();
    $("#titredarkhastselect").hide();
//    $("#etelaateShakhsi").show();
//    $("#section08").show();
//    $("#titreAzmoon").hide();}}
}
function showPayamDarkhast() {
    $("#payam").show();
    $("#cancel_payamPasokhDarkhast").show();
    $("#sendpasokhDarkhast").show();
    $('#payamHayeManForm').show();
    $('#cancel_payamPasokh').hide();
    $('#sendpasokh').hide();
    $("#payamHayeManTbl").hide();
    $("#payamhayeDaryafti").show();
    $("#payamhayeErsali").show();
    $("#titredarkhastselect").hide();
    $("#cancel_payamJaded").hide();
    $("#savabeghePayamha").hide();
    $('#paygham').show();
    $('#frestande').show();
    $('#swDarkhasthaForm').hide();
    $('#cancel_SavabegheDarkhast').hide();
//    $("#Information").show();
}
function cancel_payamPasokhDarkhast() {
    $('#payamHayeManForm').hide();
    $("#cancel_payamPasokhDarkhast").hide();
    $("#sendpasokhDarkhast").hide();
    $('#paygham').hide();
    $('#frestande').hide();
    $('#Information').show();
}
function cancel_bazgashteErsali() {
    $('#payamHayeManForm').hide();
    $("#cancel_payamPasokhDarkhast").hide();
    $("#sendpasokhDarkhast").hide();
    $('#paygham').hide();

    $('#Information').hide();
    $('#PayamhayeErsaliMan').show();
    $('#frestande').hide();
    $('#girandeErsal').hide();


}



//    $("#Information").show();


function showformDarkhast() {
    $("#Information").hide();
    $('#swDarkhasthaForm').show();
//    $("#PayamhayeInDarkhast").hide();
    $('#cancel_SavabegheDarkhast').show();
    $('#edit_DarkhastDavar').show();
    $("#axplus").show();
    $("#payamhyeindarkhast").show();
    $("#payam").hide();
    $('#ersal').hide();
    $('#save_Darkhastha').hide();
    $('#cancel_Darkhastha').hide();



//    $("#Information").show();
}
//function showformbarayelaghvePayam() {
////          alert("showformPayam()...");
//    $("#Information").show();
//    $('#payam').hide();
//    $('#cancel_Darkhastha').hide();
//
//
//}
function showformPayam() {

    $("#payamHayeManTbl").hide();
    $("#payam").show();
    $("#etelatshakhs").hide();
    $("#axplus").hide();
//     $("#payamha_frestande").show();
    $("#sendpasokh").show();
    $('#sendpayam').hide();
    $("#frestande").show();
    $('#paygham').show();
    $('#payamHayeManForm').show();
    $('#swDarkhasthaForm').hide();
    $('#PayamhayeDaryahftiMan').hide();
    $('#PayamhayeErsaliMan').hide();
    $('#payamhayeDaryafti').show();
    $('#payamhayeErsali').show();
    $('#cancel_SavabegheDarkhast').show();
    $('#cancel_payamJaded').hide();
    $('#cancel_payamPasokh').show();


//    $("#Information").show();
}
function showTblPayam() {

    $("#payamHayeManTbl").show();
    $('#payamHayeManForm').hide();
    $('#swDarkhasthaForm').hide();
    $('#savabeghePayamha').hide();

    $('#ersal').hide();
}
function laghveSavabegheDarkhast() {
    $("#Information").hide();

    $("#axplus").hide();
    $("#titredarkhastselect").hide();
    $('#swDarkhasthaForm').hide();
    $('#ersal').hide();
    $('#save_Darkhastha').hide();
    $('#cancel_Darkhastha').hide();
    recovery();
//    darkhasthyeDavare();
}
/**
 * در پنل اعضای کارگروه
 * @returns {undefined}
 */
function hideForm() {
    $('#AsareErjaShodeBeOzveKargrouh').show();
//    new jj("#swDarkhasthaForm").jjFormClean();
    $('#swDarkhasthaForm').hide();
    $("#darkhastha_nevisandegan").html("");
    $("#darkhastha_pishnahadkargroh").html("");
    $('#payamHayeMansw').hide();
    $('#titredarkhast').hide();
    asareResideBeKargrouh();

//    $("#titredarkhast").hide();
//    $('#payam').hide();
//    $('#save_Darkhastha').hide();
//    $('#cancel_Darkhastha').hide();
//    $("#Information").show();
//        cmsPayamha.tabSizeForm();

}


//function hidedarkhast() {
//    $("#Information").show();
//    $('#payam').hide();
//    $('#swDarkhasthaForm').hide();
//    $('#save_Darkhastha').hide();
//    $('#cancel_Darkhastha').hide();
//    }

function darkhastjadid() {

//    $('#').hide
//    codeDarkhast
    $("#titredarkhastselect").hide();
    $("#DavaranPishnahadi").hide();
$("#filehaSabteNahaei").show();
    
    $("#axplus").hide();
    $("#fileha").show();
    $("#CancelPayamhaDarkhast").hide();
    $("#nevisandegan").hide();
    $("#cod").hide();
    $("#EditDiv").hide();
    $("#etelatshakhs").hide();
    $('#edameAzFormDarkhatha').show();
    $('#editformSabtenam').hide();
    $('#payamhayeDaryafti').show();
    $('#payamhayeErsali').show();
    $('#PayamhayeErsaliMan').hide();
    $('#PayamhayeDaryahftiMan').hide();
    $('#deleteNevisande').hide();
    $('#swDarkhasthaForm').show();
    $('#darkhasthaForm').show();
    $('#darkhasthaFormAfterSabteNahaei').hide();
    $('#PayamhayeInDarkhastAfterSabteNahaei').hide();
    $('#filehaAfterSabteNahaei').hide();
    $("#titredarkhast").show();
    $("#Information").hide();
    $("#payamHayeManTbl").hide();
    $('#payamHayeManForm').hide();
    $('#payam').hide();
    $('#ersal').hide();
    $('#cancel_SavabegheDarkhast').hide();
    $('#save_Darkhastha').show();
    $('#cancel_Darkhastha').show();
    $('#downloadefileketab').removeAttr("href");
    $('#downloadefileketab').hide();
    $('#downloadaxjeld').hide();
    $('#downloadaxjeld').removeAttr("href");
    $('#darkhastha_file_name').val("");
    $('#darkhastha_ax_name').val("");
    var param = "";
    param += "do=Darkhastha.defualtNevisande";
    jj(param).jjAjax2(false);

    m_cleanDarkhastha();
}
function m_cleanDarkhastha() {
//    $('#downloadefileketab').removeAttr("href");
//    $('#downloadaxjeld').removeAttr("href");
    $('#darkhastha_file_name').val("");
    $('#darkhastha_ax_name').val("");
    $('#darkhastha_ax_preview').attr("src", "img/preview.jpg");
    $('#PayamhayeInDarkhast').html("");
    $('#taeedeNahaieDiv').html("");

    $('#darkhastha_title').css("box-shadow", "unset");
    $('#darkhastha_kalamatekelide').css("box-shadow", "unset");
    $('#darkhastha_chekidehketab').css("box-shadow", "unset");
    $('#darkhastha_nevisandegan').css("box-shadow", "unset");
    $('#upload_file_ketab').css("box-shadow", "unset");
    $('#upload_ax').css("box-shadow", "unset");
    $('#darkhastha_pishnahadkargroh').css("box-shadow", "unset");
    $('#darkhastha_tedadesafeketab').css("box-shadow", "unset");
    $('#darkhastha_file_name').css("box-shadow", "unset");
    $('#user_name').css("box-shadow", "unset");
    $('#user_lastname').css("box-shadow", "unset");
    $('#user_afillation').css("box-shadow", "unset");
    $('#user_email').css("box-shadow", "unset");
    $('#user_nam').css("box-shadow", "unset");
    $('#user_family').css("box-shadow", "unset");
    $('#user_sazman').css("box-shadow", "unset");
    $('#user_address').css("box-shadow", "unset");
    $('#usernamDavar').css("box-shadow", "unset");
    $('#userfamilyDavar').css("box-shadow", "unset");
    $('#userEmailDavar').css("box-shadow", "unset");
    $('#userTakhasusDavar').css("box-shadow", "unset");
    $('#usermobileDavar').css("box-shadow", "unset");
    $('#upload_file_ketab').val("");
    $('#user_grade').val("");

    $("#darkhastha_nevisandegan").html("");
    $("#darkhastha_pishnahadkargroh").html("");
    new jj("#payamHayeManForm").jjFormClean();
    new jj("#payamha_title").jjFormClean();
    new jj("#payamha_text1").jjFormClean();
    new jj("#swDarkhasthaForm").jjFormClean();
    new jj("#darkhasthaForm").jjFormClean();

//          new jj("#payamha_frestande").jjFormClean();
    new jj("#swDarkhasthaForm").jjFormClean();
    new jj("#payam").jjFormClean();
}


function ersaleDarkhast() {

    var flag = true;
    ///name (E)
    if (new jj('#darkhastha_title').jjVal() !== "") {
        $('#darkhastha_title').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorDarkhastMessagePanel1").html('');
//        validateflag = true;
    } else {
        $("#darkhastha_title").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorDarkhastMessagePanel1").html('');
        flag = false;
    }

    if (new jj('#darkhastha_kalamatekelide').jjVal() !== "") {
        $('#darkhastha_kalamatekelide').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorDarkhastMessagePanel2").html('');

//        validateflag = true;
    } else {
        $("#darkhastha_kalamatekelide").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorDarkhastMessagePanel2").html('');

        flag = false;
    }


    if (new jj('#darkhastha_chekidehketab').jjVal() !== "") {
        $('#darkhastha_chekidehketab').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorDarkhastMessagePanel4").html('');

//        validateflag = true;
    } else {
        $("#darkhastha_chekidehketab").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorDarkhastMessagePanel4").html('');

        flag = false;
    }

//    if (new jj('#darkhastha_attachFile').jjVal() !== "") {
//        $('#darkhastha_attachFile').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
//        $("#darkhastha_attachFile").html('');
//
////        validateflag = true;
//    } else {
//        $("#darkhastha_attachFile").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
//        $("#darkhastha_attachFile").html('');
//
//        flag = false;
//    }
//    if ($('#downloadefileketab').val() !== "") {
//        $('#upload_file_ketab').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
//        $("#upload_file_ketab").html('');
//
////        validateflag = true;
//    } else {
//        $("#downloadefileketab").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
//        $("#upload_file_ketab").html('');
//
//        flag = false;
//    }

    if ($('#darkhastha_nevisandegan').html() !== "") {
        $('#darkhastha_nevisandegan').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorDarkhastMessagePanel7").html('');

//       validateflag = true;
    } else {
        $("#darkhastha_nevisandegan").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorDarkhastMessagePanel7").html('');
////
        flag = false;
    }

    var count = $('#darkhastha_pishnahadkargroh .form-control').size();
    if (count >= 2) {

//   if ($('#darkhastha_pishnahadkargroh').html() !== "") {
        $('#darkhastha_pishnahadkargroh').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorDarkhastMessagePanel10").html('');
        flag = true;

////
//    }

    } else {
        $("#darkhastha_pishnahadkargroh").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorDarkhastMessagePanel10").html('');
        flag = false;
//       validateflag = true;
    }


    if (new jj('.file').jjVal() !== "") {
        $('.file').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorDarkhastMessagePanel8").html('');

//        validateflag = true;
    } else {
        $(".file").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorDarkhastMessagePanel8").html('');

        flag = false;
    }

    if (!flag) {
        return false;
    }
    var param = "";
    param += "do=Darkhastha.insertByUser&";
    var nevisandegan = $("#darkhastha_nevisandegan input");
    var temp = "&darkhastha_nevisandegan=";
    for (var i = 0; i < nevisandegan.length; i++) {
        if ($(nevisandegan[i]).val() != "") {
            temp += $(nevisandegan[i]).val();
            temp += "#A#";// هر نویسنده را با این رشته خاص از دیگری جدا م یکنیم
        }
    }

    param += "&" + new jj("#swDarkhasthaForm").jjSerial();
    var pishnahadkargroh = $("#darkhastha_pishnahadkargroh input");
    var temp2 = "&darkhastha_pishnahadkargroh=";
    for (var i = 0; i < pishnahadkargroh.length; i++) {
        if ($(pishnahadkargroh[i]).val() != "") {
            temp2 += $(pishnahadkargroh[i]).val();
            temp2 += "#A#";// هر نویسنده را با این رشته خاص از دیگری جدا م یکنیم
        }
    }
    param += temp2 + temp;
    ;
    param += "&" + new jj("#darkhastha_pishnahadkargroh").jjSerial();
    param += "&" + new jj("#darkhastha_nevisandegan").jjSerial();

    jj(param).jjAjax2(false);
     new jj("در خواست شما مرحله ثبت اولیه قرار دارد لطفا بعد از بررسی مجدد درخواست دکمه ثبت نهایی را بزنید(درقسمت درخواست ها)").jjDialog();
    ("");



}
function namayeshDarkhastEnteshar() {
    document.getElementById('darkhasthaShow').style.display = 'block';
    $("html, body").delay(1000).animate({scrollTop: $('#darkhasthaShow').offset().top}, 1000);
}
function MoshahedeEtelateSabteDarkhast(id) {
    var param = "";
    param += "do=Darkhastha.MoshahedeEtelateSabteDarkhast";
    param += "&id" + "=" + (id == null ? "" : id);
    jj(param).jjAjax2(false);
}

function recovery() {
    reportStatus();
    var param = "";
    param += "do=Darkhastha.recovery";
    param += "&panel=Information";
    $("#Information").show();
    $("#CancelPayamhaDarkhast").hide();
    $("#girandeyepayam").hide();
    $("#sendpayam").hide();
    $("#cancel_payamJaded").hide();
    $("#frestande").hide();
    $("#cancel_bazgashteErsali").hide();
    $("#sendpasokh").hide();
    $("#cancel_payamPasokh").hide();

    $("#axplus").hide();
    $("#etelatshakhs").hide();
    $("#titredarkhastselect").hide();
    $("#titredarkhast").hide();
    $("#payamHayeMansw").hide();
    $("#payamHayeManTbl").hide();
    $('#swDarkhasthaForm').hide();
    $('#PayamhayeErsaliMan').hide();
    $('#PayamhayeDaryahftiMan').hide();
    $('#ersal').hide();
//    $('#payam').hide();
//    $('#save_Darkhastha').hide();
//    $('#cancel_Darkhastha').hide();
    jj(param).jjAjax2(false);
}
function darkhasthyeDavare() {
    reportStatus();
    var param = "";
    param += "do=DarkhastDavaran.darkhasthyeDavare";
//    param += "&panel=darkhasthayeDavare";
    $("#Information").hide();
    $("#darkhasthayeDavare").show();

    $("#titredarkhast").hide();
    $("#payamHayeMansw").hide();
    $("#payamHayeManTbl").hide();
    $('#swDarkhasthaForm').hide();
    $('#ersal').hide();
//    $('#payam').hide();
//    $('#save_Darkhastha').hide();
//    $('#cancel_Darkhastha').hide();
    jj(param).jjAjax2(false);
}
function payamhayeman() {
    reportStatus();
    var param = "";
    param += "do=Payamha.refreshPayamhayemanInSite";
    param += "&panel=payamHayeManTbl";
    $("#AsareErjaShodeBeOzveKargrouh").hide();
    $("#axplus").hide();
    $("#Information").hide();
    $("#titredarkhast").hide();
    $("#titredarkhastselect").hide();
    $("#PayamhayeDaryahftiMan").hide();
    $("#PayamhayeErsaliMan").hide();
    $("#payamHayeMansw").show();
    $("#payamhayeErsali").show();
    $("#payamhayeDaryafti").show();
    $("#etelatshakhs").hide();

    showTblPayam();
//    $("#payamHayeManTbl").show();
//    $('#swDarkhasthaForm').hide();
    $('#ersal').hide();
//    $('#save_Darkhastha').hide();
//    $('#cancel_Darkhastha').hide();
    jj(param).jjAjax2(false);
}
function ersalpasokh() {
    var param = "";
    param += "do=Payamha.pasokh";
    param += "&id=" + $("#Payamha_id").val();
    param += "&payamha_text=" + new jj("#payamha_text2").jjVal();
    param += "&payamha_title=" + new jj("#payamha_title2").jjVal();
//    param += "&" + new jj("#girandeyepayam").jjSerial();

    jj(param).jjAjax2(false);
    showersalpasokh();
    m_cleanDarkhastha();
//        pmsDarkhastha.m_show_tbl();
//        pmsDarkhastha.m_cleanDarkhastha();
}
function sendpasokhDarkhast() {
    var param = "";
    param += "do=Payamha.sendpasokhDarkhast";
    param += "&id=" + $("#Payamha_id").val();
    param += "&payamha_text=" + new jj("#payamha_text2").jjVal();
    param += "&payamha_title=" + new jj("#payamha_title2").jjVal();
//    param += "&" + new jj("#girandeyepayam").jjSerial();

    jj(param).jjAjax2(false);

    showDarkhast();
//    showersalpasokh();
    m_cleanDarkhastha();
//        pmsDarkhastha.m_show_tbl();
//        pmsDarkhastha.m_cleanDarkhastha();
}
function showDarkhast() {
    $("#PayamhayeInDarkhast").show();
    $("#sendpasokhDarkhast").hide();
    $("#cancel_payamPasokhDarkhast").hide();
    $("#payamHayeManForm").hide();
}
function checkFrestandeAndEmail() {

    var param = "";
    param += "do=Payamha.checkFrestandeAndEmail";
    param += "&email=" + new jj('#payamha_email').jjVal();
//    param += "&girande=" + new jj('#payamha_girande').jjVal();
//    param += "&idgirande=" + new jj('#girandeid').jjVal();
//emailsahyh();
    $("#sendpasokh").hide();
    $("#sendpayam").show();

//    param += "&" + new jj('#FormDarkhastEtebar').jjSerial();

    jj(param).jjAjax2(false);


}
function  showTozihat() {



    $("#tozihVaTarykh").show();
    $("#show").hide();
    $("#hide").show();
}
function  hideTozihat() {
    $("#show").show();
    $("#hide").hide();

    $("#tozihVaTarykh").hide();
}
function ersalpayam() {

    var param = "";
    param += "do=Payamha.insert";
//      param += "&id=" + $("#Payamha_id").val();
    param += "&" + new jj("#girandeyepayam").jjSerial();
//    param += "&" + new jj("#payamha_girandeId").jjSerial();
    $("#girandeyepayam").hide();
    $("#PayamhayeMantbl").show();
    $("#payamHayeManForm").hide();
    $("#sendpasokh").hide();
    $("#checkFrestandeAndEmail").hide();
    $("#sendpayam").hide();
    $("#cancel_payam").hide();
//    ersalPayamBaEmail();
    jj(param).jjAjax2(false);
// checkFrestandeAndEmail();
//    SavabeghePayamha();
}
function ersalPayamBaEmail() {
    var param = "";
    param += "do=Payamha.ersalPayamBaEmail";
    param += "&email=" + new jj('#payamha_email').jjVal();
    $("#payamHayeManTbl").show();
    $("#PayamhayeErsaliMan").show();
//    payamHayeManTbl

    jj(param).jjAjax2(false);
}

/**
 * ثبت موقت نظر عضو کارگروه
 * @param {type} id
 * @returns {undefined}
 */
function sabteMovaghat(id) {
    var param = "";
    param += "do=DarkhasthayeErjaeshodebeAzayeKargroh.sabteMovaghat";
    param += "&id=" + id;

//    param += "&kargroh_darkhast_mahiateketab=" + $('input[name=kargroh_darkhast_mahiateketab]:checked').val();
//    param += "&kargroh_darkhast_eslahat=" + $('input[name=kargroh_darkhast_eslahat]:checked').val();
//    param += "&kargroh_darkhast_hazine=" + $('input[name=kargroh_darkhast_hazine]:checked').val();
//    param += "&kargroh_darkhast_ersalbarayedavari=" + $('input[name=kargroh_darkhast_ersalbarayedavari]:checked').val();
//    param += "&kargroh_darkhast_vazeiateketab=" + $('input[name=kargroh_darkhast_vazeiateketab]:checked').val();
//    param += "&payamha_text="+"&payamha_text1";
    param += "&" + new jj("#swDarkhasthaForm").jjSerial();
    jj(param).jjAjax2(false);
//    alert('ثبت موقت بدون تایید نهایی');
//    showersalpasokh();
//    m_cleanDarkhastha();
//        pmsDarkhastha.m_show_tbl();
//        pmsDarkhastha.m_cleanDarkhastha();
}
function sabteNahaie(id) {
    var param = "";
    param += "do=DarkhasthayeErjaeshodebeAzayeKargroh.sabteNahaie";
    param += "&id=" + id;

    param += "&kargroh_darkhast_mahiateketab=" + $('input:radio[name=kargroh_darkhast_mahiateketab]:checked').val();
    param += "&kargroh_darkhast_eslahat=" + $('input:radio[name=kargroh_darkhast_eslahat]:checked').val();
    param += "&kargroh_darkhast_hazine=" + $('input:radio[name=kargroh_darkhast_hazine]:checked').val();
    param += "&kargroh_darkhast_ersalbarayedavari=" + $('input:radio[name=kargroh_darkhast_ersalbarayedavari]:checked').val();
//    param += "&payamha_text="+"&payamha_text1";
    param += "&" + new jj("#swDarkhasthaForm").jjSerial();

    $('#AsareErjaShodeBeOzveKargrouh').show();
    asareResideBeKargrouh();
    jj(param).jjAjax2(false);
    showersalpasokh();
    m_cleanDarkhastha();
//        pmsDarkhastha.m_show_tbl();
//        pmsDarkhastha.m_cleanDarkhastha();
}
function sabteMovaghatDarkhastDavar(id) {

    var param = "";
    param += "do=DarkhastDavaran.sabteMovaghatDarkhastDavar";
    param += "&id=" + id;
    param += "&pms_darkhastdavaran_pasokh=" + $('input:radio[name=pms_darkhastdavaran_pasokh]:checked').val();
    param += "&pms_darkhastdavaran_pasokh1=" + $('input:radio[name=pms_darkhastdavaran_pasokh1]:checked').val();
    param += "&pms_darkhastdavaran_pasokh2=" + $('input:radio[name=pms_darkhastdavaran_pasokh2]:checked').val();
    param += "&pms_darkhastdavaran_pasokh3=" + $('input:radio[name=pms_darkhastdavaran_pasokh3]:checked').val();
    param += "&pms_darkhastdavaran_pasokh4=" + $('input:radio[name=pms_darkhastdavaran_pasokh4]:checked').val();
    param += "&pms_darkhastdavaran_pasokh5=" + $('input:radio[name=pms_darkhastdavaran_pasokh5]:checked').val();
    param += "&pms_darkhastdavaran_pasokh6=" + $('input:radio[name=pms_darkhastdavaran_pasokh6]:checked').val();
    param += "&pms_darkhastdavaran_pasokh7=" + $('input:radio[name=pms_darkhastdavaran_pasokh7]:checked').val();
    param += "&pms_darkhastdavaran_pasokh8=" + $('input:radio[name=pms_darkhastdavaran_pasokh8]:checked').val();
    param += "&pms_darkhastdavaran_pasokh9=" + $('input:radio[name=pms_darkhastdavaran_pasokh9]:checked').val();
//        param += "&pms_darkhastdavaran_pasokh10=" + $('input:radio[name=pms_darkhastdavaran_pasokh10]:checked').val();
    param += "&pms_darkhastdavaran_pasokh11=" + $('input:radio[name=pms_darkhastdavaran_pasokh11]:checked').val();
    param += "&pms_darkhastdavaran_pasokh12=" + $('input:radio[name=pms_darkhastdavaran_pasokh12]:checked').val();
    param += "&pms_darkhastdavaran_pasokh13=" + $('input:radio[name=pms_darkhastdavaran_pasokh13]:checked').val();
    param += "&pms_darkhastdavaran_pasokh14=" + $('input:radio[name=pms_darkhastdavaran_pasokh14]:checked').val();
//        param += "&" + new jj('#swDarkhastDavaranForm').jjSerial();




//    param += "&payamha_text="+"&payamha_text1";
    param += "&" + new jj("#darkhastdavar").jjSerial();
    jj(param).jjAjax2(false);
//    alert('ثبت موقت بدون تایید نهایی');
//    showersalpasokh();
//    m_cleanDarkhastha();
//        pmsDarkhastha.m_show_tbl();
//        pmsDarkhastha.m_cleanDarkhastha();
}
function sabteNahaieDarkhastDavar(id) {

    var param = "";
    param += "do=DarkhastDavaran.sabteNahaieDarkhastDavar";
    param += "&id=" + id;
    param += "&idDavar=" + new jj("#pms_darkhastdavaran_id").jjVal();

    param += "&pms_darkhastdavaran_pasokh=" + $('input:radio[name=pms_darkhastdavaran_pasokh]:checked').val();
    param += "&pms_darkhastdavaran_pasokh1=" + $('input:radio[name=pms_darkhastdavaran_pasokh1]:checked').val();
    param += "&pms_darkhastdavaran_pasokh2=" + $('input:radio[name=pms_darkhastdavaran_pasokh2]:checked').val();
    param += "&pms_darkhastdavaran_pasokh3=" + $('input:radio[name=pms_darkhastdavaran_pasokh3]:checked').val();
    param += "&pms_darkhastdavaran_pasokh4=" + $('input:radio[name=pms_darkhastdavaran_pasokh4]:checked').val();
    param += "&pms_darkhastdavaran_pasokh5=" + $('input:radio[name=pms_darkhastdavaran_pasokh5]:checked').val();
    param += "&pms_darkhastdavaran_pasokh6=" + $('input:radio[name=pms_darkhastdavaran_pasokh6]:checked').val();
    param += "&pms_darkhastdavaran_pasokh7=" + $('input:radio[name=pms_darkhastdavaran_pasokh7]:checked').val();
    param += "&pms_darkhastdavaran_pasokh8=" + $('input:radio[name=pms_darkhastdavaran_pasokh8]:checked').val();
    param += "&pms_darkhastdavaran_pasokh9=" + $('input:radio[name=pms_darkhastdavaran_pasokh9]:checked').val();
//        param += "&pms_darkhastdavaran_pasokh10=" + $('input:radio[name=pms_darkhastdavaran_pasokh10]:checked').val();
    param += "&pms_darkhastdavaran_pasokh11=" + $('input:radio[name=pms_darkhastdavaran_pasokh11]:checked').val();
    param += "&pms_darkhastdavaran_pasokh12=" + $('input:radio[name=pms_darkhastdavaran_pasokh12]:checked').val();
    param += "&pms_darkhastdavaran_pasokh13=" + $('input:radio[name=pms_darkhastdavaran_pasokh13]:checked').val();
    param += "&pms_darkhastdavaran_pasokh14=" + $('input:radio[name=pms_darkhastdavaran_pasokh14]:checked').val();
//  



    param += "&" + new jj("#darkhastdavar").jjSerial();
    darkhasthyeDavare();

    jj(param).jjAjax2(false);

    cleanDarkhastDavar();
//        pmsDarkhastha.m_show_tbl();
//        pmsDarkhastha.m_cleanDarkhastha();
}
function cleanDarkhastDavar() {
    new jj("#darkhastdavar").jjFormClean();
    $('input:radio[name=pms_darkhastdavaran_pasokh3]:checked').prop('checked', false);
    $('input:radio[name=pms_darkhastdavaran_pasokh]:checked').prop('checked', false);
    $('input:radio[name=pms_darkhastdavaran_pasokh1]:checked').prop('checked', false);
    $('input:radio[name=pms_darkhastdavaran_pasokh2]:checked').prop('checked', false);
    $('input:radio[name=pms_darkhastdavaran_pasokh3]:checked').prop('checked', false);
    $('input:radio[name=pms_darkhastdavaran_pasokh4]:checked').prop('checked', false);
    $('input:radio[name=pms_darkhastdavaran_pasokh5]:checked').prop('checked', false);
    $('input:radio[name=pms_darkhastdavaran_pasokh6]:checked').prop('checked', false);
    $('input:radio[name=pms_darkhastdavaran_pasokh7]:checked').prop('checked', false);
    $('input:radio[name=pms_darkhastdavaran_pasokh8]:checked').prop('checked', false);
    $('input:radio[name=pms_darkhastdavaran_pasokh9]:checked').prop('checked', false);
//         $('input:radio[name=pms_darkhastdavaran_pasokh10]:checked').prop('checked', false);
    $('input:radio[name=pms_darkhastdavaran_pasokh11]:checked').prop('checked', false);
    $('input:radio[name=pms_darkhastdavaran_pasokh12]:checked').prop('checked', false);
    $('input:radio[name=pms_darkhastdavaran_pasokh13]:checked').prop('checked', false);
    $('input:radio[name=pms_darkhastdavaran_pasokh14]:checked').prop('checked', false);
}
function editDarkhastByUser(id) {
    var param = "";
    param += "do=Darkhastha.editDarkhastByUser&";
    param += "&id=" + id;
    var nevisandegan = $("#darkhastha_nevisandegan input");
    var temp = "&darkhastha_nevisandegan=";
    for (var i = 0; i < nevisandegan.length; i++) {
        if ($(nevisandegan[i]).val() != "") {
            temp += $(nevisandegan[i]).val();
            temp += "#A#";// هر نویسنده را با این رشته خاص از دیگری جدا م یکنیم
        }
    }

    param += "&" + new jj("#swDarkhasthaForm").jjSerial();
    var pishnahadkargroh = $("#darkhastha_pishnahadkargroh input");
    var temp2 = "&darkhastha_pishnahadkargroh=";
    for (var i = 0; i < pishnahadkargroh.length; i++) {
        if ($(pishnahadkargroh[i]).val() != "") {
            temp2 += $(pishnahadkargroh[i]).val();
            temp2 += "#A#";// هر نویسنده را با این رشته خاص از دیگری جدا م یکنیم
        }
    }
    param += temp2 + temp;
    ;
    param += "&" + new jj("#darkhastha_pishnahadkargroh").jjSerial();
    param += "&" + new jj("#darkhastha_nevisandegan").jjSerial();

    jj(param).jjAjax2(false);


//    var param = "";
//    param += "do=Darkhastha.editDarkhastByUser";
//    param += "&id=" + id;
//    var temp = "&darkhastha_nevisandegan=";
//    // میتواند چندین نویسنده داشته باشد
//    var nevisandegan = $("#darkhastha_nevisandegan input");
////    alert(nevisandegan.length);
//    for (var i = 0; i < nevisandegan.length; i++) {
////        alert($(nevisandegan[i]).val());
//        if ($(nevisandegan[i]).html() != "") {
//            temp += $(nevisandegan[i]).html();
//            temp += "#A#";// هر نویسنده را با این رشته خاص از دیگری جدا م یکنیم
//        }
//    }
//    param += temp;
//    temp = "";
//    var DavaranePishnahadi = $("#darkhastha_pishnahadkargroh input");
//    for (var i = 0; i < DavaranePishnahadi.length; i++) {
//        if ($(DavaranePishnahadi[i]).html() != "") {
//            temp += $(DavaranePishnahadi[i]).html();
//            temp += "#A#";// هر نویسنده را با این رشته خاص از دیگری جدا م یکنیم
//        }
//    }
//    param += "&darkhastha_pishnahadkargroh=" + temp;
//    param += "&" + new jj("#swDarkhasthaForm").jjSerial();
//
//    jj(param).jjAjax2(false);
//    m_cleanDarkhastha();

//        pmsDarkhastha.m_show_tbl();
//        pmsDarkhastha.m_cleanDarkhastha();
}

function  showersalpasokh() {
    $("#payamHayeManTbl").show();
    $('#payamHayeManForm').hide();
    $('#swDarkhasthaForm').hide();
    $('#savabeghePayamha').hide();

    $('#ersal').hide();


}
//////////پنل اعضای کارگروه
function asareResideBeKargrouh() {
    reportStatus();
    var param = "";
    param += "do=DarkhasthayeErjaeshodebeAzayeKargroh.AsareResideBeKargrouh";
    $("#AsareErjaShodeBeOzveKargrouh").show();
    $('#swDarkhasthaForm').hide();
    $("#titr").show();
    $("#payamHayeMansw").hide();
    $("#payamHayeManTbl").hide();

//    $('#swDarkhasthaForm').hide();
//    $('#ersal').hide();
//    $('#payam').hide();
//    $('#save_Darkhastha').hide();
//    $('#cancel_Darkhastha').hide();
    jj(param).jjAjax2(false);
}
function selectPanelAzeyeKargrouh(id) {

//    $("#kargroh_darkhast_file1").val();
//   $("#kargroh_darkhast_file2").val();
    var param = "";
    param += "do=DarkhasthayeErjaeshodebeAzayeKargroh.selectPanelAzeyeKargrouh";
    param += "&id" + "=" + (id == null ? "" : id);

    $('#AsareErjaShodeBeOzveKargrouh').hide();
    $('#downloadefileketabafterSend').hide();
    $('#downloadAxAfterSend').hide();
      $('#kargroh_darkhast_file2').removeAttr('disabled', 'disabled');
    $('#kargroh_darkhast_file1').removeAttr('disabled', 'disabled');
    $('#kargroh_darkhast_file1_file').show();
    $('#kargroh_darkhast_file2_file').show();
    $("#kargroh_darkhast_file1").val("");
    $('#sendAxjeld').show();
    $('#sendKetabFile').show();
    $('#mateneTaghirat1').show();
    $('#mateneTaghirat2').show();
    showformAsareDarkhast();
    jj(param).jjAjax2(false);
    reportStatus();
}
function selectPanelAzeyeKargrouhAfterSabteNahaei(id) {

    var param = "";
    param += "do=DarkhasthayeErjaeshodebeAzayeKargroh.selectPanelAzeyeKargrouhAfterSabteNahaei";
    param += "&id" + "=" + (id == null ? "" : id);
    $("#AsareErjaShodeBeOzveKargrouh").hide();
    $('#kargroh_darkhast_file2').attr('disabled', 'disabled');
    $('#kargroh_darkhast_file1').attr('disabled', 'disabled');
    $('#swDarkhasthaForm').show();
    $('#cancel_SavabegheDarkhast').hide();

//    $("#fileAzayeKargrouh").hide();
    $('#swDarkhasthaForm').show();
    $('#kargroh_darkhast_file1_file').hide();
    $('#kargroh_darkhast_file2_file').hide();
    $('#sendAxjeld').hide();
    $('#sendKetabFile').hide();
    $('#mateneTaghirat1').hide();
    $('#mateneTaghirat2').hide();
//    showformAsareDarkhast();
    jj(param).jjAjax2(false);
    reportStatus();
}



function showformAsareDarkhast() {
    $("#AsareErjaShodeBeOzveKargrouh").hide();
    $('#swDarkhasthaForm').show();
    $('#cancel_SavabegheDarkhast').hide();

//    $("#PayamhayeInDarkhast").show();
//    $('#cancel_SavabegheDarkhast').show();
//    $("#payamhyeindarkhast").show();
//    $("#payam").hide();
//    $('#ersal').hide();
//    $('#save_Darkhastha').hide();
//    $('#cancel_Darkhastha').hide();
//    $("#Information").show();
}
function nevisandegan() {
    $("#nevisandegan").show();
    $("#editformSabtenam").show();
    $("#deleteNevisande").show();

}
function selectNevisande(id) {
    $("#nevisandegan").show();
    $("#afzoodanNevisande").hide();
    $("#deleteNevisande").show();
    $("#user_name").css("box-shadow", "unset");
    $("#user_afillation").css("box-shadow", "unset");
    $("#user_lastname").css("box-shadow", "unset");
    $("#user_email").css("box-shadow", "unset");
    $("#user_nam").css("box-shadow", "unset");
    $("#user_family").css("box-shadow", "unset");
    $("#user_sazman").css("box-shadow", "unset");

    var param = "";
    param += "do=Darkhastha.selectNevisande";
    param += "&id=" + id;
    jj(param).jjAjax2(false);
}
function selectNevisandeAfterSabteNahaei(id) {
    $("#nevisandeganAfterSabteNahaei").show();
    $("#afzoodanNevisandeAfterSabteNahaei").hide();
    $("#deleteNevisandeAfterSabteNahaei").hide();
    var param = "";
    param += "do=Darkhastha.selectNevisandeAfterSabteNahaei";
    param += "&id=" + id;
    jj(param).jjAjax2(false);
}
function selectDavarePishnahadi(id) {
    $("#DavaranPishnahadi").show();
    $("#afzoodanDavarePishnahadi").hide();
    $("#deleteDavar").show();
    $("#usernamDavar").css("box-shadow", "unset");
    $("#userfamilyDavar").css("box-shadow", "unset");
    $("#userEmailDavar").css("box-shadow", "unset");
    $("#userTakhasusDavar").css("box-shadow", "unset");
    $("#usermobileDavar").css("box-shadow", "unset");

    var param = "";
    param += "do=Darkhastha.selectDavarePishnahadi";
    param += "&id=" + id;
    jj(param).jjAjax2(false);
}
function selectDavarePishnahadiAfterSabteNahaei(id) {
    $("#DavaranPishnahadiAfterSabteNahaei").show();
    $("#afzoodanDavarePishnahadiAfterSabteNahaei").hide();
//    $("#deleteDavar").show();
    var param = "";
    param += "do=Darkhastha.selectDavarePishnahadiAfterSabteNahaei";
    param += "&id=" + id;
    jj(param).jjAjax2(false);
}
function afzoodaneNevisande() {
    $("#nevisandegan").show();
    $("#afzoodanNevisande").show();
    $('#edameAzFormDarkhatha').show();
    $('#fileha').show();
    var flag = true;
    ///name (E)
    var name = $("#user_name").val();
    if (validateenglish(name) && new jj('#user_name').jjVal() !== "") {
        $('#user_name').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel1").html('');

//        validateflag = true;
    } else {
        $("#user_name").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel1").html('');
//        $("#errorRegistMessagePanel1").append('لطفا نام خود را وارد کنید');
        flag = false;
    }
    var flag = true;
    ///name (E)
    var lastname = $("#user_lastname").val();
    if (validateenglish(name) && new jj('#user_lastname').jjVal() !== "") {
        $('#user_lastname').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel2").html('');

//        validateflag = true;
    } else {
        $("#user_lastname").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel2").html('');
//        $("#errorRegistMessagePanel2").append('لطفا نام خود را وارد کنید');
        flag = false;
    }
    var flag = true;
    ///name (E)
    var family = $("#user_family").val();
    if (validatepersion(family) && new jj('#user_family').jjVal() !== "") {
        $('#user_family').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel3").html('');

//        validateflag = true;
    } else {
        $("#user_family").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel3").html('');
//        $("#errorRegistMessagePanel2").append('لطفا نام خود را وارد کنید');
        flag = false;
    }
    var flag = true;
    ///name (E)
    var nam = $("#user_nam").val();
    if (validatepersion(family) && new jj('#user_nam').jjVal() !== "") {
        $('#user_nam').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel4").html('');

//        validateflag = true;
    } else {
        $("#user_nam").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel4").html('');
//        $("#errorRegistMessagePanel2").append('لطفا نام خود را وارد کنید');
        flag = false;
    }
    var flag = true;
    ///name (E)
    var afillation = $("#user_afillation").val();
    if (validateenglish(afillation) && new jj('#user_afillation').jjVal() !== "") {
        $('#user_afillation').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel5").html('');

//        validateflag = true;
    } else {
        $("#user_afillation").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel5").html('');
//        $("#errorRegistMessagePanel2").append('لطفا نام خود را وارد کنید');
        flag = false;
    }
    var sazman = $("#user_sazman").val();
    if (validatepersion(sazman) && new jj('#user_sazman').jjVal() !== "") {
        $('#user_sazman').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel7").html('');

//        validateflag = true;
    } else {
        $("#user_sazman").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel7").html('');
//        $("#errorRegistMessagePanel2").append('لطفا نام خود را وارد کنید');
        flag = false;
    }

    var email = $("#user_email").val();
    if (validateEmail(email) && new jj('#user_email').jjVal() !== "") {
        $('#user_email').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
//        validateflag = true;
        $("#errorRegistMessagePanel6").html('');
    } else {
        $("#user_email").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel6").html('');
//        $("#errorRegistMessagePanel4").append('لطفا ایمیل خود راوارد کنید');
        flag = false;
    }
    if (!flag) {
        return;
    }
    var param = "do=Access_User.afzoodaneNevisande";
    param += "&" + new jj("#nevisandegan").jjSerial();
    jj(param).jjAjax2(false);
//--------------------------------
    $('#nevisandegan').slideUp();
    $('html, body').animate({scrollTop: $('#nevisandeAsli').offset().top}, 0);
}
/**
 * این تابع یک لیست ایجاد می کند برای داوران پیشنهادی و موقع کلیک مجدد روی هر کدام آنرا حذف می کند
 * در نهایت  جی جی سریال باید از اچ تی ام ال اینها را استخراج کند و به سرور بفرستد
 * @returns {undefined}
 */
function afzoodanDavarePishnahadi() {
    $("#DavaranPishnahadi").show();
    $("#afzoodanDavarePishnahadi").show();
//    var html = "<div class='form-control davarPishnahadi' onclick='$(this).remove();'> " 
//            + $("#usernamDavar").val()+ " - "
//            + $("#usermobileDavar").val()
//    +"</div>";
//    $("#darkhastha_pishnahadkargroh").append(html);
    var flag = true;
    ///name (E)
    var nam = $("#usernamDavar").val();
    if (validatepersion(nam) && new jj('#usernamDavar').jjVal() !== "") {
        $('#usernamDavar').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel1").html('');

//        validateflag = true;
    } else {
        $("#usernamDavar").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel1").html('');
//        $("#errorRegistMessagePanel1").append('لطفا نام خود را وارد کنید');
        flag = false;
    }
    var family = $("#userfamilyDavar").val();
    if (validatepersion(family) && new jj('#userfamilyDavar').jjVal() !== "") {
        $('#userfamilyDavar').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel1").html('');

//        validateflag = true;
    } else {
        $("#userfamilyDavar").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel1").html('');
//        $("#errorRegistMessagePanel1").append('لطفا نام خود را وارد کنید');
        flag = false;
    }
    var email = $("#userEmailDavar").val();
    if (validateEmail(email) && new jj('#userEmailDavar').jjVal() !== "") {
        $('#userEmailDavar').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel1").html('');

//        validateflag = true;
    } else {
        $("#userEmailDavar").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel1").html('');
//        $("#errorRegistMessagePanel1").append('لطفا نام خود را وارد کنید');
        flag = false;
    }
    var takasus = $("#userTakhasusDavar").val();
    if (validatepersion(takasus) && new jj('#userTakhasusDavar').jjVal() !== "") {
        $('#userTakhasusDavar').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel1").html('');

//        validateflag = true;
    } else {
        $("#userTakhasusDavar").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel1").html('');
//        $("#errorRegistMessagePanel1").append('لطفا نام خود را وارد کنید');
        flag = false;
    }
    var mobile = $("#usermobileDavar").val();
    if (validatePhone(mobile) && new jj('#usermobileDavar').jjVal() !== "") {
        $('#usermobileDavar').css("box-shadow", "2px 0px 10px 2px rgba(1,50, 60, 0.8)");
        $("#errorRegistMessagePanel1").html('');

//        validateflag = true;
    } else {
        $("#usermobileDavar").css("box-shadow", "2px 0px 10px 2px rgba(100, 10, 20,1)");
        $("#errorRegistMessagePanel1").html('');
//        $("#errorRegistMessagePanel1").append('لطفا نام خود را وارد کنید');
        flag = false;
    }
    if (!flag) {
        return;
    }
    var param = "do=Access_User.afzoodanDavarePishnahadi";
    param += "&" + new jj("#DavaranPishnahadi").jjSerial();
    jj(param).jjAjax2(false);
//--------------------------------
    $('#DavaranPishnahadi').slideUp();
//    $('html, body').animate({
//        scrollTop: $("#nevisandeAsli").offset().top
//    }, 500);
}
function afzoodanKargrouh() {
//    $("#DavaranPishnahadi").show();
//    $("#afzoodanDavarePishnahadi").show();
//    var html = "<div class='form-control davarPishnahadi' onclick='$(this).remove();'> " 
//            + $("#usernamDavar").val()+ " - "
//            + $("#usermobileDavar").val()
//    +"</div>";
//    $("#darkhastha_pishnahadkargroh").append(html);
    var param = "do=Access_User.afzoodanKargrouh";
    param += "&pms_kargrohha_id=" + $("#selectKargrohha").val();
    param += "&" + new jj("#sabtenameSarye").jjSerial();
    jj(param).jjAjax2(false);
//--------------------------------
    $('#sabtenameSarye').slideUp();
//    $('html, body').animate({
//        scrollTop: $("#nevisandeAsli").offset().top
//    }, 500);
}


function showFromAfzoodaneNevisande() {
    new jj("#nevisandegan").jjFormClean();
    $('#user_email').removeAttr('disabled');
    $("#deleteNevisande").hide();
    $("#edameAzFormDarkhatha").hide();
    $("#fileha").hide();
    $("#nevisandegan").show();
    $("#afzoodanNevisande").show();
    $('#user_name').css("box-shadow", "unset");
    $('#user_lastname').css("box-shadow", "unset");
    $('#user_afillation').css("box-shadow", "unset");
    $('#user_email').css("box-shadow", "unset");
    $('#user_nam').css("box-shadow", "unset");
    $('#user_family').css("box-shadow", "unset");
    $('#user_sazman').css("box-shadow", "unset");
    $('#user_address').css("box-shadow", "unset");
    $('#user_grade').css("box-shadow", "unset");
    $('#user_mobile').css("box-shadow", "unset");
    $('#user_codemeli').css("box-shadow", "unset");
    $('#user_ShomareShenasname').css("box-shadow", "unset");
    $('#user_grade').val("");
}
function showFromDavarePishnahadi() {
    new jj("#DavaranPishnahadi").jjFormClean();
    $('#user_email').removeAttr('disabled');
//    $("#deleteNevisande").hide();
    $("#DavaranPishnahadi").show();
    $("#afzoodanDavarePishnahadi").show();
    $("#deleteDavar").hide();
    $("#usernamDavar").css("box-shadow", "unset");
    $("#userfamilyDavar").css("box-shadow", "unset");
    $("#userEmailDavar").css("box-shadow", "unset");
    $("#userTakhasusDavar").css("box-shadow", "unset");
    $("#usermobileDavar").css("box-shadow", "unset");
}
function deleteNevisande() {
    var id = $("#nevisandeUserID").val();
    $("#darkhastha_nevisandegan" + id).remove();
    new jj("#nevisandegan").jjFormClean();

    $('#nevisandegan').slideUp();
    $('html, body').animate({scrollTop: $('#nevisandeAsli').offset().top}, 0);
}
function deleteDavarepishnahadi() {
    var id = $("#DavarUserID").val();
    $("#darkhastha_pishnahadkargroh" + id).remove();
    new jj("#DavaranPishnahadi").jjFormClean();

    $('#DavaranPishnahadi').slideUp();
//    $('html, body').animate({scrollTop: $('#nevisandeAsli').offset().top}, 0);
}

//  function editDarkhastDavar(){
//     var param = "";
//    param += "do=DarkhastDavaran.editDarkhastDavar";
//    param += "&id" + "=" + (id == null ? "" : id);
//      param += "&" + new jj("#darkhastdavar").jjSerial();
//      new jj("#darkhastdavar").jjFormClean();
//    jj(param).jjAjax2(false);
//     
//     
// }
function TakmileKargrouh() {
    reportStatus();
    var param = "";
    param += "do=DarkhasthayeErjaeshodebeSarparastKargroh.TakmileKargrouh";
    $("#swformSarparastKargroh").hide();
    $("#sarparastKargroh").hide();
    $("#TakmileKargrouh").show();
    $("#TakmileDavari").hide();
//    sarparastKargroh
    $('#swDarkhasthaForm').hide();
    $("#titr").hide();
    $("#payamHayeMansw").hide();
    $("#payamHayeManTbl").hide();
//    $('#swDarkhasthaForm').hide();
//    $('#ersal').hide();
//    $('#payam').hide();
//    $('#save_Darkhastha').hide();
//    $('#cancel_Darkhastha').hide();
    jj(param).jjAjax2(false);
}
;
function TakmileDavari() {
//    reportStatus();
    var param = "";
    param += "do=DarkhasthayeErjaeshodebeSarparastKargroh.TakmileDavari";
    $("#swformSarparastKargroh").hide();
    $("#sarparastKargroh").hide();
    $("#TakmileKargrouh").hide();
    $("#TakmileDavari").show();
//    sarparastKargroh
    $('#swDarkhasthaForm').hide();
    $("#titr").hide();
    $("#payamHayeMansw").hide();
    $("#payamHayeManTbl").hide();
//    $('#swDarkhasthaForm').hide();
//    $('#ersal').hide();
//    $('#payam').hide();
//    $('#save_Darkhastha').hide();
//    $('#cancel_Darkhastha').hide();
    jj(param).jjAjax2(false);
}
;
function asareResidebeSarparastKargroh() {
    reportStatus();
    var param = "";
    param += "do=DarkhasthayeErjaeshodebeSarparastKargroh.asareResidebeSarparastKargroh";
    $("#swformSarparastKargroh").hide();
    $("#sarparastKargroh").show();
    $("#TakmileKargrouh").hide();

    $("#TakmileDavari").hide();
    $("#cancel_DarkhasthayTakmileKargrouh").hide();
//    sarparastKargroh
    $('#swDarkhasthaForm').hide();
    $("#titr").hide();
    $("#payamHayeMansw").hide();
    $("#payamHayeManTbl").hide();
//    $('#swDarkhasthaForm').hide();
//    $('#ersal').hide();
//    $('#payam').hide();
//    $('#save_Darkhastha').hide();
//    $('#cancel_Darkhastha').hide();
    jj(param).jjAjax2(false);
}
;

function selectAsareResideBeSarparastKargroh(id) {
    reportStatus();
    var param = "";
    param += "do=DarkhasthayeErjaeshodebeSarparastKargroh.selectAsareResideBeSarparastKargroh";
    param += "&id" + "=" + (id == null ? "" : id);
    $("#cancel_DarkhasthayTakmileDavari").hide();

    showformSarparastKargroh();

    jj(param).jjAjax2(false);
}
function selectTakmilKargrouh(id) {
    reportStatus();
    var param = "";
    param += "do=DarkhasthayeErjaeshodebeSarparastKargroh.selectTakmilKargrouh";
    param += "&id" + "=" + (id == null ? "" : id);
    $("#swformSarparastKargroh").show();
    $("#selecteAzayekargorouhha2").hide();
    $("#selecteDavarnDarSarparast").hide();

    $("#formNazarat").hide();
    $("#ErjaBeKarshenas").hide();
    $("#taghirevaziat").show();
    $("#TakmileKargrouh").hide();
    $("#changeStatusTakmileDavari").hide();
    $("#actionDarkhasthaErjaShodeSelect").hide();
    $("#taghirevaziat").hide();
    $("#cancel_DarkhasthayEerjaeshodeBeSarparast").hide();
    $("#cancel_DarkhasthayTakmileKargrouh").show();
    $("#cancel_DarkhasthayTakmileDavari").hide();
//    showformSarparastKargroh();

    jj(param).jjAjax2(false);
}
function selectTakmileDavari(id) {
    reportStatus();
    var param = "";
    param += "do=DarkhasthayeErjaeshodebeSarparastKargroh.selectTakmileDavari";
    param += "&id" + "=" + (id == null ? "" : id);
    $("#TakmileKargrouh").hide();
    $("#TakmileDavari").hide();
    $("#cancel_DarkhasthayTakmileKargrouh").hide();
    $("#cancel_DarkhasthayTakmileDavari").show();
    $("#DarkhastBeDavareNahaieDarSite").show();
    $("#ersalBeDarkhathaBeDavarn").show();
    $("#ersalBeDavaranBarayeDarkhastDarDavareNahaie").hide();
    $("#ListDavaranForDavareNahaie").hide();
    $("#cancel_DarkhasthayEerjaeshodeBeSarparast").hide();
    $("#taghirevaziat").hide();

    $("#swformSarparastKargroh").show();
    $("#ersalBeDavaranBarayeDarkhastDarsite1").hide();
    $("#selecteDavarnDarSarparast").hide();
    $("#ersalBeAzayeKargroohBarayeDarkhast2").hide();
    $("#actionDarkhasthaErjaShodeSelect").hide();
    $("#changeStatusTakmileDavari").show();
//    showformSarparastKargroh();
    $("#sarparastKargroh").hide();
    $("#formNazarat").hide();
    jj(param).jjAjax2(false);
//    showformbarayelaghvePayam();

}
function showformSarparastKargroh(id) {

    $("#taghirevaziat").show();
    $("#selecteAzayekargorouhha2").hide();
    $("#selecteDavarnDarSarparast").hide();
    $("#TakmileKargrouh").hide();
    $("#ersalBeAzayeKargroohBarayeDarkhast2").show();
    $("#sarparastKargroh").hide();
    $("#actionDarkhasthaErjaShodeSelect").show();
    $("#changeStatusTakmileDavari").hide();
    $("#formNazarat").hide();
    $("#cancel_DarkhasthayEerjaeshodeBeSarparast").show();
    $("#swformSarparastKargroh").show();
}
//taeedeNahaie(" + id + ");
function sabteNaheiYes(id) {

    new jj(" پس از ثبت نهایی دیگر امکان ویرایش درخواست وجود ندارد آیا مطمئن هستید؟").jjDialog_YesNo('taeedeNahaie(' + id + ');\n', true, "");
}
;
function taeedeNahaie(id) {
    var param = "";
    param += "do=Darkhastha.taeedeNahaie";
    param += "&id=" + id;
//    param += "&payamha_text="+"&payamha_text1";

    param += "&" + new jj("#girandeyepayam").jjSerial();

    $("#axplus").hide();
    $("#darkhasthaShow").hide();
    jj(param).jjAjax2(false);

}
function LaghveDarkhasthayEerjaeshodeBeSarparast() {
    $("#sarparastKargroh").show();

    $("#swformSarparastKargroh").hide();
    asareResidebeSarparastKargroh();

}
function DarkhasthayTakmileKargrouh() {
    $("#TakmileKargrouh").show();
    $("#sarparastKargroh").hide();
    $("#swformSarparastKargroh").hide();

}
function DarkhasthayTakmileDavari() {
    $("#TakmileKargrouh").hide();
    $("#sarparastKargroh").hide();
    $("#TakmileDavari").show();

    $("#swformSarparastKargroh").hide();

}
;
function makeSelected(id) {
    $(".selectedCategory").removeClass("selectedCategory");
    $("#uperNodeA" + id).addClass("selectedCategory");
}
function searchproduct() {
    if ($('#jjSearchInput').val().length < 2) {
        return "";
    }
    new jj('do=Product.searchProduct&text=' + (new jj('#jjSearchInput').jjVal()) + '&panel=sw&jj=1&title=swTitle').jjAjax2(true);
}
;
function autoLogin(email, pass) {

    $("#login_user_email").val(email);
    $("#login_user_pass").val(pass);
    jj("do=Access_User.loginUserSafheAsli&panel=" + setting_login_exit_panel.replace("#", "") + "&" + new jj("#loginForm").jjSerial()).jjAjax2(false);
}
function worodsabt() {

//      $('#worod_li').hide();
//location.href = $(this).attr('href');
    $('#sabtename').hide();
    $('#menuWorod').show();
//           $('#menuWorod').addClass('.content fourth-content') ;  
//      $('.content fourth-content').show();

}

// function tarykheTavalod(){
//     new jj('#user_tarykhTavalod').jjCalendarWithYearSelector(1310, 1410);
// }
function payamhayeErsali() {
    var param = "";
    param += "do=Payamha.payamhayeErsali";
    $("#PayamhayeErsaliMan").show();
    $("#axplus").hide();
    $("#darkhasthaForm").hide();
    $("#etelatshakhs").hide();
    $("#frestande").hide();
    $("#cancel_bazgashteErsali").hide();
    $("#girandeyepayam").hide();
    $("#cancel_payamJaded").hide();
    $("#sendpayam").hide();
    $("#CancelPayamhaDarkhast").hide();
    $("#titredarkhast").hide();
    $("#Information").hide();
    $("#payamHayeManTbl").hide();
    $("#titredarkhastselect").hide();
    $("#PayamhayeDaryahftiMan").hide();
    $("#swDarkhasthaForm").hide();
    jj(param).jjAjax2(false);
}
function profileShakhsi() {
    var param = "";
    param += "do=Access_User.profileShakhsi";

    jj(param).jjAjax2(false);
}






function payamhayeDaryafti() {
    reportStatus();
    var param = "";
    param += "do=Payamha.payamhayeDaryafti";
    $("#PayamhayeErsaliMan").hide();
    $("#cancel_bazgashteErsali").hide();
    $("#CancelPayamhaDarkhast").hide();

    $("#Information").hide();
    $("#frestande").hide();
    $("#girandeyepayam").hide();
    $("#cancel_payamPasokh").hide();
    $("#sendpasokh").hide();
    $("#swDarkhasthaForm").hide();
    $("#titredarkhastselect").hide();
    $("#etelatshakhs").hide();
    $("#axplus").hide();
    $("#darkhasthaForm").hide();
    $("#titredarkhast").hide();
    $("#payamHayeManTbl").hide();
    $("#PayamhayeDaryahftiMan").show();
    jj(param).jjAjax2(false);




}
function cancel_payamJaded() {

    $("#payamHayeManTbl").hide();
    $('#payamHayeManForm').hide();
    $('#swDarkhasthaForm').hide();
    $('#darkhasthaForm').hide();

    $("#PayamhayeInDarkhast").hide();
    $('#cancel_SavabegheDarkhast').hide();
    $('#edit_DarkhastDavar').hide();
    $('#PayamhayeErsaliMan').show();

    $("#payamhyeindarkhast").hide();
    $("#payam").hide();
    $('#ersal').hide();
    $('#save_Darkhastha').hide();
    $('#cancel_Darkhastha').hide();

}
function cancel_payamPasokh() {
    payamhayeDaryafti();
    reportStatus();
//   refreshPayamhayemanInSite()
    $("#payamHayeManTbl").show();
    $('#payamHayeManForm').hide();
    $('#payamhayeDaryafti').hide();
    $('#payamhayeErsali').show();
    $('#payamhayeDaryafti').show();
    $('#PayamhayeDaryahftiMan').show();
    $('#PayamhayeErsaliMan').hide();
    $("#payamha_title").html("");
    $("#payamha_date").html("");
    $("#payamha_text").html("");
}
//function download(){
//    
//      $('#downloadefileketab').attr('href', 'upload/' + $('#darkhastha_file_name').val());
//    
//    
//}
function reportStatus() {
    var param = "";

    param += "do=Report.getStatusSite";

    jj(param).jjAjax2(false);
}
//function confirmExit()
//{
//
//    
//    if (ret_confirm == true)
//    {
//        window.alert("Ok");
//    } else
//        window.alert("Cancel");
//}
function forget() {

    $("#log_id").hide();
    $("#login_user_pass").hide();
    $("#regested_id").hide();
    $("#pass").hide();
//        $("#user_pass").hide();
    $("#forgetEmail").hide();
    $("#BazgashtBaSafheWorod").show();
    $("#sendEmail").show();


}
function forgetSabtenam() {

    $("#loginBtnPardakht").hide();
    $("#user_pass_pardakht").hide();
    $("#registBtnPardakht").hide();
    $("#passSabtenam").hide();
//        $("#user_pass").hide();
    $("#forgetEmailSabtenam").hide();
    $("#BazgashtBaSafheWorodSabtenam").show();
    $("#sendEmailSabtenam").show();


}
function  sendEmail() {
    var param = "";
    param += "do=Access_User.sendEmail";
    param += "&email1=" + new jj('#login_user_email').jjVal();

    jj(param).jjAjax2(false);


}
function  sendEmailPardakht() {
    var param = "";
    param += "do=Access_User.sendEmail";
    param += "&email1=" + new jj('#user_email_pardakht').jjVal();

    jj(param).jjAjax2(false);


}
function BazgashtBaSafheWorod() {
    $("#log_id").show();
    $("#pass").show();
    $("#login_user_pass").show();
    $("#regested_id").show();
    $("#BazgashtBaSafheWorod").hide();
    $("#sendEmail").hide();
    $("#forgetEmail").show();
    $("#titredarkhastselect").hide();

}
function BazgashtBaSabtenam() {
    $("#loginBtnPardakht").show();
    $("#passSabtenam").show();
    $("#user_pass_pardakht").show();
    $("#registBtnPardakht").show();
    $("#BazgashtBaSafheWorodSabtenam").hide();
    $("#sendEmailSabtenam").hide();
    $("#forgetEmailSabtenam").show();
    $("#titredarkhastselect").hide();

}
function editEtelaat() {
    var param = "";
    param += "do=Access_User.editEtelaat";
//    param += "&id=" +id;
//param += "&id=" + id;
//    param += "&idAccessUser=" + new jj('#Access_User_id').jjVal();
    $("#etelateshakhs").show();
    $("#titredarkhastselect").hide();

    param += "&" + new jj('#etelatshakhs').jjSerial();

    jj(param).jjAjax2(false);
}
function  showPayamhayeInDarkhast() {
    $("#PayamhayeInDarkhast").show();
}
function  hidePayamhayeInDarkhast() {
    $("#PayamhayeInDarkhast").slideUp();
}
function cancelformeDavaran() {
    $("#cancelformeDavaran").hide();
    $("#FormeDavaran").hide();

}
function cancelformeDarkhastBeAza() {
    $("#cancelformeDarkhastBeAza").hide();
    $("#formeDarkhasthayeErjaBeKargrouh").hide();

}

//var gotoSlideN = function (n) {
//    $(".cd-hero-slider .selected").removeClass('selected from-left from-right').addClass('is-moving').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
//        $(".cd-hero-slider .selected").removeClass('is-moving');
//    });
//    var selectedPosition = n,
//            activePosition = $('.cd-hero-slider .selected').index();
//    if (activePosition < selectedPosition) {
//        $(".cd-hero-slider").children('li').eq(n).addClass('selected from-left').nextAll().addClass('move-left');
//    } else {
//        $(".cd-hero-slider").children('li').eq(n).addClass('selected from-left').prevAll().addClass('move-right');
//    }
//};
var gotoSlideN = function (n) {
    var selectedPosition = n,
            activePosition = $('.cd-hero-slider .selected').index();
    if (activePosition < selectedPosition) {
        $(".cd-hero-slider .selected").removeClass('selected from-left from-right').addClass('is-moving').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
            $(".cd-hero-slider .selected").removeClass('is-moving');
        });

        $(".cd-hero-slider").children('li').eq(n).addClass('selected from-left').nextAll().addClass('move-left');
        $("#worod_li").removeClass('selected');


        $("#regist_li").addClass('selected');
    } else {
        $(".cd-hero-slider .selected").removeClass('selected from-left from-right').addClass('is-moving').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
            $(".cd-hero-slider .selected").removeClass('is-moving');
        });


        $(".cd-hero-slider").children('li').eq(n).addClass('selected from-left').removeClass('move-left').nextAll().removeClass('move-left');
        $("#worod_li").addClass('selected');


        $("#regist_li").removeClass('selected');
//       container.children('li').eq(n).addClass('selected from-left').removeClass('move-left').nextAll().removeClass('move-left');
    }
};

function sabtenamPardakht() {
    $("#loginFormPardakht").hide();
    $("#registFormPardakht").show();

}
function WorodPardakht() {
    $("#loginFormPardakht").show();
    $("#registFormPardakht").hide();

}
function PardakhtNahaei() {
    var param = "";
    param += "do=Access_User.loginPardakht";
//prePayment();
    $('.bankDiv').show();
    jj(param).jjAjax2(false);
}
function RahnamayeNevisande() {
    $("#rahnamaNevisande").show();
    $("#rahnamayeDavar").hide();
    $("#rahnamayeSarparast").hide();
    $("#rahnamayeAza").hide();

}
function RahnamayeAzaKargrouh() {
    $("#rahnamaNevisande").hide();
    $("#rahnamayeDavar").hide();
    $("#rahnamayeSarparast").hide();
    $("#rahnamayeAza").show();

}
function RahnamayeSarparast() {
    $("#rahnamaNevisande").hide();
    $("#rahnamayeDavar").hide();
    $("#rahnamayeSarparast").show();
    $("#rahnamayeAza").hide();

}
function RahnamayeDavaran() {
    $("#rahnamaNevisande").hide();
    $("#rahnamayeDavar").show();
    $("#rahnamayeSarparast").hide();
    $("#rahnamayeAza").hide();

}
function RahnamayeNevisandeDarSite() {
    $("#rahnamaNevisandeDarSite").show();
    $("#rahnamayeDavarDarSite").hide();
    $("#rahnamayeSarparastDarSite").hide();
    $("#rahnamayeAzaDarSite").hide();

}
function RahnamayeAzaKargrouhDarSite() {
    $("#rahnamaNevisandeDarSite").hide();
    $("#rahnamayeDavarDarSite").hide();
    $("#rahnamayeSarparastDarSite").hide();
    $("#rahnamayeAzaDarSite").show();

}
function RahnamayeSarparastDarSite() {
    $("#rahnamaNevisandeDarSite").hide();
    $("#rahnamayeDavarDarSite").hide();
    $("#rahnamayeSarparastDarSite").show();
    $("#rahnamayeAzaDarSite").hide();

}
function RahnamayeDavaranDarSite() {
    $("#rahnamaNevisandeDarSite").hide();
    $("#rahnamayeDavarDarSite").show();
    $("#rahnamayeSarparastDarSite").hide();
    $("#rahnamayeAzaDarSite").hide();

}
function printMali() {
    window.print();
}
///این تابع برای نمایش مراحل انجام خرید
function showLinkPardakht() {
     $("#loginFormSamane").hide();
    $("#detailMahsoul").hide();
    $("#anjameKharid").show();
}
function SavabegheKharid() {
    var param = "";
    param += "do=Factor.SavabegheKharid";
//    param += "&email1=" + new jj('#login_user_email').jjVal();

    jj(param).jjAjax2(false);


}
function sign() {
    $("#loginForm").show();
    $("#registForm").hide();
    $(".login-wrap").css("min-height", "590px");
}
function signPardakht() {
    $("#loginFormPardakht").show();
    $("#registFormPardakht").hide();
    $(".login-wrap").css("min-height", "590px");
}
function regist() {
    $("#loginForm").hide();
    $("#registForm").show();
    $(".login-wrap").css("min-height", "2093px");
}
function registPardakht() {
    $("#loginFormPardakht").hide();
    $("#registFormPardakht").show();
    $(".login-wrap").css("min-height", "974px");
}
//function showFrame(){$('#iframe').show();}
 function checkSamaneErsal(){
      $("#user_name").on("keyup", function () {
                var str = $(this).val();
                var regx = /^[a-z ,.'-]+$/i;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_name").addClass("redBoxShadow");
                } else {
                    $("#user_name").removeClass("redBoxShadow");
                }
                ;
            });
            $("#user_lastname").on("keyup", function () {
                var str = $(this).val();
                var regx = /^[a-z ,.'-]+$/i;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_lastname").addClass("redBoxShadow");
                } else {
                    $("#user_lastname").removeClass("redBoxShadow");
                }
                ;
            });
            $("#user_organ").on("keyup", function () {
                var str = $(this).val();
                var regx = /^[a-z ,.'-]+$/i;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_organ").addClass("redBoxShadow");
                } else {
                    $("#user_organ").removeClass("redBoxShadow");
                }
                ;
            });
            $("#user_afillation").on("keyup", function () {
                var str = $(this).val();
                var regx = /^[a-z ,.'-]+$/i;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_afillation").addClass("redBoxShadow");
                } else {
                    $("#user_afillation").removeClass("redBoxShadow");
                }
                ;
            });
            $("#user_email").focusout(function () {
                var str = $(this).val();
                var regx = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_email").addClass("redBoxShadow");
                } else {
                    $("#user_email").removeClass("redBoxShadow");
                }
            });
            $("#user_weblog").on("keyup", function () {
                var str = $(this).val();
                var regx = /^[a-z ,.'-]+$/i;
                if (!regx.test(str)) {
                    $(this).val("");
                }
                ;
            });
            $("#user_pass").focusout(function () {
                var str = $(this).val();
                var regx = (/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/);
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_pass").addClass("redBoxShadow");
                } else {
                    $("#user_pass").removeClass("redBoxShadow");
                }
            });
            $("#user_pass_2").focusout(function () {
                var str = $(this).val();
                var regx = (/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/);
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_pass_2").addClass("redBoxShadow");
                } else {
                    $("#user_pass_2").removeClass("redBoxShadow");
                }
                ;
            });
            $("#user_nam").focusout(function () {
                var str = $(this).val();
                var regx = /^([\u0600-\u06FF].{1,30}\s*)$/;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_nam").addClass("redBoxShadow");
                } else {
                    $("#user_nam").removeClass("redBoxShadow");
                }
                ;
            });
            $("#user_family").focusout(function () {
                var str = $(this).val();
                var regx = /^([\u0600-\u06FF].{1,30}\s*)$/;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_family").addClass("redBoxShadow");
                } else {
                    $("#user_family").removeClass("redBoxShadow");
                }
                ;
            });
            $("#user_reshte").focusout(function () {
                var str = $(this).val();
                var regx = /^([\u0600-\u06FF].{1,30}\s*)$/;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_reshte").addClass("redBoxShadow");
                } else {
                    $("#user_reshte").removeClass("redBoxShadow");
                }
                ;
            });
            $("#user_sazman").focusout(function () {
                var str = $(this).val();
                var regx = /^([\u0600-\u06FF].{1,30}\s*)$/;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_sazman").addClass("redBoxShadow");
                } else {
                    $("#user_sazman").removeClass("redBoxShadow");
                }
                ;
            });

            $("#user_address").focusout(function () {
                var str = $(this).val();
                var regx = /^([\u0600-\u06FF].{1,30}\s*)$/;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_address").addClass("redBoxShadow");
                } else {
                    $("#user_address").removeClass("redBoxShadow");
                }
                ;
            });
            $("#user_codemeli").focusout(function () {
                var str = $(this).val();
                var regx = /^[0-9]{10}$/;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_codemeli").addClass("redBoxShadow");
                } else {
                    $("#user_codemeli").removeClass("redBoxShadow");
                }
                ;
            });
            $("#user_shomareShenasname").focusout(function () {
                var str = $(this).val();
                var regx = /^[0-9]{1,}$/;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_shomareShenasname").addClass("redBoxShadow");
                } else {
                    $("#user_shomareShenasname").removeClass("redBoxShadow");
                }
                ;
            });
            $("#user_mobile").focusout(function () {
                var str = $(this).val();
                var regx = /^(09|9)[0-9]{9}$/;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_mobile").addClass("redBoxShadow");
                } else {
                    $("#user_mobile").removeClass("redBoxShadow");
                }
                ;
            });
 }
 function checkSabtenam(){
    
//            $("#user_lastname").on("keyup", function () {
//                var str = $(this).val();
//                var regx = /^[a-z ,.'-]+$/i;
//                if (!regx.test(str)) {
//                    $(this).val("");
//                    $("#user_lastname").addClass("redBoxShadow");
//                } else {
//                    $("#user_lastname").removeClass("redBoxShadow");
//                }
//                ;
//            });
          
           
            $("#user_email_pardakht2").focusout(function () {
                var str = $(this).val();
                var regx = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_email_pardakht2").addClass("redBoxShadow");
                } else {
                    $("#user_email_pardakht2").removeClass("redBoxShadow");
                }
            });
           
            $("#user_pass_pardakht2").focusout(function () {
                var str = $(this).val();
                var regx = (/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/);
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_pass_pardakht2").addClass("redBoxShadow");
                } else {
                    $("#user_pass_pardakht2").removeClass("redBoxShadow");
                }
            });
            $("#user_pass_2_pardakht").focusout(function () {
                var str = $(this).val();
                var regx = (/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/);
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_pass_2_pardakht").addClass("redBoxShadow");
                } else {
                    $("#user_pass_2_pardakht").removeClass("redBoxShadow");
                }
                ;
            });
            $("#user_nam_pardakht").focusout(function () {
                var str = $(this).val();
                var regx = /^([\u0600-\u06FF].{1,30}\s*)$/;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_nam_pardakht").addClass("redBoxShadow");
                } else {
                    $("#user_nam_pardakht").removeClass("redBoxShadow");
                }
                ;
            });
            $("#user_family_pardakht").focusout(function () {
                var str = $(this).val();
                var regx = /^([\u0600-\u06FF].{1,30}\s*)$/;
                if (!regx.test(str)) {
                    $(this).val("");
                    $("#user_family_pardakht").addClass("redBoxShadow");
                } else {
                    $("#user_family_pardakht").removeClass("redBoxShadow");
                }
                ;
            });
           

//            $("#user_address").focusout(function () {
//                var str = $(this).val();
//                var regx = /^([\u0600-\u06FF].{1,30}\s*)$/;
//                if (!regx.test(str)) {
//                    $(this).val("");
//                    $("#user_address").addClass("redBoxShadow");
//                } else {
//                    $("#user_address").removeClass("redBoxShadow");
//                }
//                ;
//            });
//          
//          
//            $("#user_mobile").focusout(function () {
//                var str = $(this).val();
//                var regx = /^(09|9)[0-9]{9}$/;
//                if (!regx.test(str)) {
//                    $(this).val("");
//                    $("#user_mobile").addClass("redBoxShadow");
//                } else {
//                    $("#user_mobile").removeClass("redBoxShadow");
//                }
//                ;
//            });
 }