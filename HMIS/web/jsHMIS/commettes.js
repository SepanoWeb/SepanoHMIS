/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisCommettes = {
    tableName: "Commettes",
    f_id: "id",
    loadForm: function () {
        if ($("#swCommettesForm").html() == '') {
            $("#swCommettesForm").load("formHMIS/05newCommette.html", null, function () {
                $('#sessions_time').wickedpicker();
                new jj("#commettes_date").jjCalendarWithYearSelector(1397, 1420);
                new jj("#sessions_date").jjCalendarWithYearSelector(1397, 1420);
                new jj("#sessions_dateReminder").jjCalendarWithYearSelector(1397, 1420);
                new jj('#sendDocumentCommettes').jjAjaxFileUploadTitleUploadFiles('#attachDocumentCommettes', '#commettes_documentsFile', 'commettes_titleFile1', '#commettes_files1Title', "#showFiles1Div");
                new jj('#sendPicFilesCommettes').jjAjaxFileUploadTitleUploadFiles('#attachFileCommettes', '#commettes_regulationFile', 'commettes_titleFile2', '#commettes_files2Title', "#showFiles2Div");
                new jj('#sendFilesInvitees').jjAjaxFileUploadTitleUploadFiles('#attachFileInvitees', '#sessions_InviteesFile', 'sessions_titleFile1', '#commettes_filesTitle', "#showFilesDiv");
                hmisRole.getSelectOption("#swCommettesForm #commettes_secretary");// برای قرار گرفتن سلکت آپشن نقش ها در قسمت های مربوطه
                hmisRole.getSelectOption("#swCommettesForm #commettes_superwizar");// برای قرار گرفتن سلکت آپشن نقش ها در قسمت های مربوطه
                $("#commettes_secretary").select2({
                    minimumResultsForSearch: '',
                    width: '100%'
                });
                $("#commettes_superwizar").select2({
                    minimumResultsForSearch: '',
                    width: '100%'
                });

                hmisCommettes.m_refresh();
                $('#newCommetteForm').show();
                $('#formInvitation').hide();
            });
        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisCommettes.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swCommettesTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? 800 : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
    },
    m_show_form: function () {
        $('#swCommettesTbl').hide();
        $('#swCommettesForm').show();
        hmisCommettes.tabSizeForm();
    },
    m_clean: function () {
        new jj("#" + hmisCommettes.f_content_id).jjVal("");
        new jj("#" + hmisCommettes.f_title).jjVal("");
        new jj("#" + hmisCommettes.f_lang).jjVal("1");
        new jj("#" + hmisCommettes.f_parent).jjVal("0");
        $("#inputTextSelectorDiv1").html("");
        $("#inputTextSelectorDiv2").html("");

    },
    m_add_new: function () {
        new jj("do=" + hmisCommettes.tableName + ".add_new&jj=1").jjAjax2(false);
        hmisCommettes.m_show_form();
        $('#newCommetteForm').show();
        $('#formInvitation').hide();
        hmisCommettes.m_clean();
        //        oEditor.execCommand( 'bold');

    },
    m_show_tbl: function () {
        $('#swCommettesTbl').show();
        $('#swCommettesForm').hide();
        if ($('#swCommettesTbl').html() == "") {
            hmisCommettes.m_refresh();
        }
        hmisCommettes.tabSizeTbl();
    },
    m_insert: function () {
//        var valid =  hmisCommettes.m_validation();
//        if (valid == "") {
        var param = "";
        var temp2 = "";
        var temp = $("#inputTextSelectorDiv input");
        for (var i = 0; i < temp.length; i++) {
            temp2 += $(temp[i]).val() + "%23A%23";
        }
        var flag = true;
        if ($("#commettes_superwizar option:selected").val() == "") {
            $("#commettes_superwizar").addClass("required");
            flag = false;


        } else {
            $("#commettes_superwizar").removeClass('required');
        }
        if ($("#commettes_title").val() == "") {
            $("#commettes_title ").addClass("required");
            flag = false;
        } else {
            $("#commettes_title").removeClass('required');
        }
        if ($("#commettes_secretary option:selected").val() == "") {
            $("#commettes_secretary").addClass("required");

            flag = false;
        } else {
            $("#commettes_secretary").removeClass("required");
        }
        if ($("#commettes_members").val() == "") {
            $("#refreshRoles").addClass("required");
//                                $("html, body").delay(1000).animate({scrollTop: $('#refreshRoles').offset().top}, 800);

            flag = false;
        } else {
            $("#refreshRoles").removeClass("required");
        }
        if (flag == true) {
            param += "&do=" + hmisCommettes.tableName + ".insert";
            param += "&commettes_documentsFile=" + temp2;
            param += "&" + new jj('#newCommetteForm').jjSerial();
            new jj(param).jjAjax2(false);
            hmisCommettes.m_show_tbl();
            hmisCommettes.m_clean();

        }
        $("html, body").delay(1000).animate({scrollTop: $('#newCommetteForm').offset().top}, 800);

    },
    m_edit: function () {
        var flag = true;
        if ($("#commettes_superwizar option:selected").val() == "") {
            $("#commettes_superwizar").addClass("required");
            flag = false;


        } else {
            $("#commettes_superwizar").removeClass('required');
        }
        if ($("#commettes_title").val() == "") {
            $("#commettes_title ").addClass("required");
            flag = false;
        } else {
            $("#commettes_title").removeClass('required');
        }
        if ($("#commettes_secretary option:selected").val() == "") {
            $("#commettes_secretary").addClass("required");

            flag = false;
        } else {
            $("#commettes_secretary").removeClass("required");
        }
        if ($("#commettes_members").val() == "") {
            $("#refreshRoles").addClass("required");
//                                $("html, body").delay(1000).animate({scrollTop: $('#refreshRoles').offset().top}, 800);

            flag = false;
        } else {
            $("#refreshRoles").removeClass("required");
        }
        if (flag == true) {
            var temp2 = "";
            var param = "";
            param += "&do=" + hmisCommettes.tableName + ".edit";
            param += "&" + new jj('#newCommetteForm').jjSerial();
            param += "&id=" + new jj('#hmis_commettes_id').jjVal();
            var temp = $("#inputTextSelectorDiv input");
            for (var i = 0; i < temp.length; i++) {
                temp2 += $(temp[i]).val() + "%23A%23";
            }
            param += "&commettes_documentsFile=" + temp2;
            new jj(param).jjAjax2(false);
            hmisCommettes.m_show_tbl();
            hmisCommettes.m_clean();
        }
    },
//    m_validation: function () {// mohamdad
//        if (new jj("#content_title").jjVal().length < 1) {
//            return "فیلد عنوان نباید کوچکتر از دو کاراکتر باشد";
//        }
//        return "";
    //    },
    m_delete: function (id) {
        if (confirm("آیا از حذف این رکورد اطمینان دارید؟")) {
            hmisCommettes.m_delete_after_question(id);
        } else {
        }
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisCommettes.tableName + ".delete";
        param += "&" + hmisCommettes.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisCommettes.m_show_tbl();
        hmisCommettes.m_clean();
    },
    m_select: function (id) {
        $('#showFiles2Div').html("");
        $('#showFiles1Div').html("");
        $('#swCommettesForm  select').removeClass("required");
        $('#swCommettesForm  input').removeClass("required");
        $('#swCommettesForm  #refreshRoles').removeClass("required");
        $('#inputTextSelectorDiv1').val("");
        $('#inputTextSelectorDiv2').val("");
        $('#commettes_documentsFile').val("");
        $('#commettes_regulationFile').val("");

        $('#newCommetteForm').show();
        $('#formInvitation').hide();
        var param = "";
        param += "do=" + hmisCommettes.tableName + ".select";
        param += "&" + hmisCommettes.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisCommettes.m_show_form();
    },
    m_add_EN: function (id) {
        var param = "";
        param += "do=" + hmisCommettes.tableName + ".add_EN";
        param += "&" + hmisCommettes.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisCommettes.f_parent).jjVal(id);
        new jj("#" + hmisCommettes.f_lang).jjVal("2");
        hmisCommettes.m_show_form();
    },
    m_add_Ar: function (id) {
        var param = "";
        param += "do=" + hmisCommettes.tableName + ".add_Ar";
        param += "&" + hmisCommettes.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisCommettes.f_parent).jjVal(id);
        new jj("#" + hmisCommettes.f_lang).jjVal("3");
        hmisCommettes.m_show_form();
    },
    //============ BY RASHIDI ========>
    m_add_Ln: function (id, langId) {
        var param = "";
        param += "do=" + hmisCommettes.tableName + ".add_lang";
        param += "&" + hmisCommettes.f_id + "=" + (id == null ? "" : id);
        param += "&myLang=" + (langId == null ? "1" : langId);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisCommettes.f_parent).jjVal(id);
        new jj("#" + hmisCommettes.f_lang).jjVal(langId);
        //        alert(id+"&&&&&"+langId);
        hmisCommettes.m_show_form();
    },
    //<============ BY RASHIDI ========
    m_searchTextInTitle: function (text) {
        var param = "";
        param += "do=" + hmisCommettes.tableName + ".searchTextInTitle";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    m_searchTextInAll: function (text) {
        var param = "";
        param += "do=" + hmisCommettes.tableName + ".searchTextInAll";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    //============ BY RASHIDI ========>    
    m_searchTags: function () {
        var param = "";
        param += "do=" + hmisCommettes.tableName + ".searchTags";
        param += "&" + new jj('#swCommettesForm').jjSerial();
        new jj(param).jjAjax2(false);
    },
    m_insertTags: function () {
        var param = "";
        param += "do=" + hmisCommettes.tableName + ".insertTags";
        param += "&" + new jj('#swCommettesForm').jjSerial();
        new jj(param).jjAjax2(false);
    },
    //<============ BY RASHIDI ========    
    tabSizeTbl: function () {
        $('#swCommettes').css('height', 520);
    },
    tabSizeForm: function () {
        $('#swCommettes').css('height', 378);
    },
    /////////////////////shiran////////////
    showInvitationForm: function (commeteId) {
        hmisCommettes.m_show_form();
        $('#hmis_commettes_id').val(commeteId);
        $('#newCommetteForm').hide();
        $('#formInvitation').show();
        $('#addButton1').show();
        var param = "";
        param += "&id=" + new jj("#hmis_commettes_id").jjVal();
        param += "&do=" + hmisCommettes.tableName + ".showInvitationForm";
        param += "&jj=1";
        new jj(param).jjAjax2(false);
    },

    Invitees: function () {//مدعوین


        var param = "";
        var temp = $('#InviteesDiv input:checkbox[class=checkBoxInvitees]:checked'); //مدعوین سمت دار
        var InviteesOutSide = $('#InviteesDiv .invitedOutSide');
        var InviteesInSide = $('#sessions_InviteesInSide').val();
        if (temp.size() == 0) {//اگر تیک عضوی را نزده بود
            alert("لطفا افراد را انتخاب کنید");
            temp.addClass('required');
            return;
        }
        var temp1 = "";
        var temp2 = "";
        var temp3 = "";
        var temp4 = "";
        var temp5 = "";
        ///////////////////////مدعوین سمت دار
        for (var i = 0; i < temp.length; i++) {
            temp1 += $(temp[i]).attr('value') + "%23A%23"; //نام چک باکس عدد مورد نظر
        }
        /////////////////////////////مهمانان داخل سازمان
        if (InviteesInSide != null) {
            for (var i = 0; i < InviteesInSide.length; i++) {
                temp3 += InviteesInSide[i] + "%23A%23"; //انتخاب چندین نفر وارسال ای دی افراد با جداساز
            }
        }
        ///////////////////////////////////////مهمانان خارج از سازمان
        //این قسمت نام و نام خانوادگی فرد مهمان را میگیرد واگر خالی باشد چیزی ارسال نمی شود 
        // اول دیو کلی را می گیرد  بعد اینپوت هایی که داخل دیو ها هستند را در می آورد
        var flag = true;
        var InviteesOutSideName = "";
        if (InviteesOutSide.length > 1) {
            for (var i = 1; i < InviteesOutSide.length; i++) {
                var InputInviteesOutSide = $("#InviteesDiv #invitedOutSide_" + [i] + " input");
                var name = $("#InviteesDiv #invitedOutSide_" + [i] + " .name");
                var phone = $("#InviteesDiv #invitedOutSide_" + [i] + " .phone");
                var email = $("#InviteesDiv #invitedOutSide_" + [i] + " .email");
                var role = $("#InviteesDiv #invitedOutSide_" + [i] + " .role");
                if ($("#InviteesDiv #invitedOutSide_" + [i] + " .name").val() != "" && $("#InviteesDiv #invitedOutSide_" + [i] + " .phone").val() != "" && $("#InviteesDiv #invitedOutSide_" + [i] + " .email").val() != "" && $("#InviteesDiv #invitedOutSide_" + [i] + " .role").val() != "" && (hmisCommettes.validateName(name)) && (hmisCommettes.validatePhone(phone)) && (hmisCommettes.validateEmail(email)) && (hmisCommettes.validateName(role))) {
                    temp4 +=  $("#InviteesDiv #invitedOutSide_" + [i] + " .name").val()+ "," +$("#InviteesDiv #invitedOutSide_" + [i] + " .phone").val() + "," + $("#InviteesDiv #invitedOutSide_" + [i] + " .email").val() + "," + $("#InviteesDiv #invitedOutSide_" + [i] + " .role").val()+ "%23A%23";
                    InviteesOutSideName = "#InviteesDiv #invitedOutSide_" + [i] + " input";
                } else {
                    flag = false;
                }
            }
        }

        if ($('#sessions_date').val() === "") {
            $('#sessions_date').addClass('required');
//            flag = false;
        } else {
            $('#sessions_date').removeClass('required');
        }
        if ($('#sessions_dateReminder').val() === "") {
            $('#sessions_dateReminder').addClass('required');
//            flag = false;
        } else {
            $('#sessions_dateReminder').removeClass('required');
        }
        if ($('#sessions_time').val() === "") {
            $('#sessions_time').addClass('required');
//            flag = false;
        } else {
            $('#sessions_time').removeClass('required');
        }
        if ($("#formInvitation input.required").length > 0) {//اگر فیلدی خالی وجو داشتکه کلاسش required بود
            flag = false;
        }
        if (flag === true) {
            param += "&sessions_Invitees=" + temp1;
            param += "&sessions_InviteesInSide=" + temp3; //مهمان داخل  سازمان
            param += "&sessions_InviteesOutSide=" + temp4; //مهمان خارج از  سازمان
            param += "&commettesId=" + new jj("#hmis_commettes_id").jjVal(); //ای دی کمیته
            param += "&" + new jj('#formInvitation').jjSerial();
            param += "&do=Sessions.requestSendComment&jj=1";
            new jj(param).jjAjax2(false);
        } else {
            new jj("همه فیلد ها را پر کنید.").jjModal("پیام سامانه");
        }
    },
    addMembers: function (i) {
        var temp1 = "";
        var param = "";
        if ($("#td" + i + " i").attr('class') === "icon ion-checkmark-circled") {
            $("#td" + i + " i").attr('class', 'icon ion-plus-circled').css("color", "red");
        } else if ($("#td" + i + " i").attr('class') === "icon ion-plus-circled") {
            var RoleId = $("#td" + i + " i").attr('id');
            $("#td" + i + " i").attr('class', 'icon ion-checkmark-circled').css("color", "green");

        }
        var temp = $("#tableRolesDiv #refreshRoles .ion-checkmark-circled");
        for (var i = 0; i < temp.size(); i++) {
            temp1 += $(temp[i]).attr('id') + "%23A%23";
        }
        $('#commettes_members').val(temp1);


    },
    emailRegex: function (email) {
        var emailPathern = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return emailPathern.test(email);
    },
    validateEmail: function (obj) {
        var email = $(obj).val();
        if (!hmisCommettes.emailRegex(email)) {
//            $(obj).css('border', '1px solid red');
            $(obj).addClass('required');
            return false;

        } else {
//            $(obj).css('border', '1px solid #23BF08');
            $(obj).removeClass('required');
            return true;

        }

    },
    dateRegex: function (date) {
        var datePathern = /^$|^([1۱][۰-۹ 0-9]{3}[/\/]([0 ۰][۱-۶ 1-6])[/\/]([0 ۰][۱-۹ 1-9]|[۱۲12][۰-۹ 0-9]|[3۳][01۰۱])|[1۱][۰-۹ 0-9]{3}[/\/]([۰0][۷-۹ 7-9]|[1۱][۰۱۲012])[/\/]([۰0][1-9 ۱-۹]|[12۱۲][0-9 ۰-۹]|(30|۳۰)))$/;//تاریخ شمسی
        return datePathern.test(date);
    },
    validateDate: function (obj) {
        var date = $(obj).val();
        if (!hmisCommettes.dateRegex(date)) {
//            $(obj).css('border', '1px solid red');
            $(obj).addClass('required');
            return false;

        } else {
//            $(obj).css('border', '1px solid #23BF08');
            $(obj).removeClass('required');
            return true;

        }

    },
    /**
     * نام ونام خانوادگی  فرد فقط فارسی باشد
     * @param {type} str
     * @returns {Boolean}
     */
    regexName: function (str) {
        var regx = /^[\u0600-\u06FF\s]+$/;
        return regx.test(str);
    },
    mobileRegex: function (mobile) {
        var regx = /^(09|9)[0-9]{9}$/;
        return regx.test(mobile);
    },
    validatePhone: function (obj) {
        var mobile = $(obj).val();
        if (!hmisCommettes.mobileRegex(mobile)) {
//            $(obj).css('border', '1px solid red');
            $(obj).addClass('required');
            return false;
        } else {
//            $(obj).css('border', '1px solid #23BF08');
            $(obj).removeClass('required');
            return true;


        }

    },

    validateName: function (obj) {
        var name = $(obj).val();
        if (!hmisCommettes.regexName(name)) {
            $(obj).addClass('required');
            return false;
        } else {
            $(obj).removeClass('required');
            return true;
        }

    },

    /**
     * ارسال پیام و
     *  دعوت  همه افراد انتخاب شده
     *   برای برگزاری جلسه توسط کمیته
     * @returns {undefined}
     */
    sendComment: function (text, inviteesId, inviteesOutSideId, inviteesInSideId) {
        var param = "";
        param += "&textComment=" + text;
        param += "&inviteesIdComment=" + inviteesId;
        param += "&inviteesOutSideIdComment=" + inviteesOutSideId;
        param += "&inviteesInSideIdComment=" + inviteesInSideId;
        param += "&do=" + hmisCommettes.tableName + ".sendComment" + "&jj=1";
        new jj(param).jjAjax2(false);
    },
    /**id
     *ایدی رکورد موردنطر
     *
     *
     *
     *
     * @param {type} idUpload
     * @param {type} id
     * @param {type} hmisName
     
     */
    m_remove: function (idUpload, id, nameFile) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjModal_Yes_No("پیام هشدار قبل از حذف", "hmisCommettes.removeFile(" + idUpload + "," + id + "," + nameFile + ");");
    },
    removeFile: function (idUpload, id, nameFile) {
        var param = "";
        param += "do=" + hmisCommettes.tableName + ".removeFile";
        param += "&upload_id=" + idUpload;
        param += "&id=" + id;
        param += "&nameFile=" + nameFile;
        new jj(param).jjAjax2(false);
//        hmisSessions.m_show_tbl();
//        hmisSessions.m_clean();
    },
};