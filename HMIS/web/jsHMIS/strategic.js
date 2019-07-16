/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisStrategic = {
    tableName: "Strategic",
    f_id: "id",
    loadForm: function () {
        if ($("#swStrategicForm").html() == '') {
            $("#swStrategicForm").load("formHMIS/13strategicPlan.html", null, function () {

                $("#cancel_Strategic").click(function (e) {
                    hmisStrategic.m_clean();
                    hmisStrategic.m_show_tbl();
                });
                hmisStrategic.m_refresh();
            });
        }
    },
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisStrategic.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swStrategicTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? 800 : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
    },
    m_show_form: function () {
        $('#swStrategicTbl').slideUp();
        $('#swStrategicForm').slideDown();
        hmisStrategic.tabSizeForm();
    },
    m_clean: function () {
        new jj('#swStrategicForm').jjFormClean();
        $('#tableIFE input.onkeyup').val("");
        $('#tableEFE input.onkeyup').val("");
        $('#tableIFE input.onclick').val("");
        $('#tableEFE input.onclick').val("");
        $('#tableIFE input.sumFinalVal').val("");
        $('#tableEFE input.sumFinalVal').val("");

        $('input').removeClass('red');
        $('input').removeClass('green');
//        

    },
    m_add_new: function () {
        var param = "";
        param += "&do=" + hmisStrategic.tableName + ".add_new&jj=1";
        new jj(param).jjAjax2(false);
        hmisStrategic.m_clean();
        $('#swStrategicForm').show();
        $('#swStrategicTbl').hide();
        $('div#pointer').css({'transform': 'translate(0,0)'});

    },
    m_show_tbl: function () {
        $('#swStrategicTbl').show();
        $('#swStrategicForm').hide();
        if ($('#swStrategicTbl').html() == "") {
            hmisStrategic.m_refresh();
        }
        hmisStrategic.tabSizeTbl();
    },
    m_insert: function () {
        var param = "";
        param += "&do=" + hmisStrategic.tableName + ".insert";
        param += "&strategic_IFEInternal=" + $("#tableIFE").html();
        param += "&strategic_EFEOuter=" + $("#tableEFE").html();
        param += "&strategic_IFEandEFE=" + $("#IFEandEFE").html();
        param += "&strategic_beneficiaries=" + $("#beneficiaries").html();
        param += "&strategic_matrixSWOT=" + $("#SWOTMatrixTable").html();
        param += "&strategic_strategicSWOT=" + $("#StartegiesTableOnSWOT").html();
        param += "&strategic_matrixQSPM=" + $("#tableQSPM").html();
        param += "&strategic_prioritized=" + $("#tablePrioritized").html();
        param += "&" + new jj('#swStrategicForm').jjSerial();
        new jj(param).jjAjax2(false);
        hmisStrategic.m_show_tbl();
//        hmisStrategic.m_clean();
    },
    m_edit: function () {
        var param = "";
        param += "&do=" + hmisStrategic.tableName + ".edit";
        param += "&strategic_beneficiaries=" + $("#beneficiaries").html();
        param += "&strategic_IFEInternal=" + $("#tableIFE").html();
        param += "&strategic_EFEOuter=" + $("#tableEFE").html();
        param += "&strategic_IFEandEFE=" + $("#IFEandEFE").html();
        param += "&strategic_matrixSWOT=" + $("#SWOTMatrixTable").html();
        param += "&strategic_strategicSWOT=" + $("#StartegiesTableOnSWOT").html();
        param += "&strategic_matrixQSPM=" + $("#tableQSPM").html();
        param += "&strategic_prioritized=" + $("#tablePrioritized").html();
        param += "&id=" + new jj('#hmis_strategic_id').jjVal();
        param += "&" + new jj('#swStrategicForm').jjSerial();
        new jj(param).jjAjax2(false);
        hmisStrategic.m_show_tbl();
        hmisStrategic.m_clean();
    },
//    m_validation: function () {// mohamdad
//        if (new jj("#content_title").jjVal().length < 1) {
//            return "فیلد عنوان نباید کوچکتر از دو کاراکتر باشد";
//        }
//        return "";
//    },
    /**
     * ای دی مصوبات
     * @param {type} id
     * @returns {undefined}
     */

    m_delete: function (id) {
//        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo(' hmisStrategic.m_delete_after_question(' + id + ');\n', true, "");
        if (confirm("آیا از حذف این رکورد اطمینان دارید؟")) {
            hmisStrategic.confirmationFinalStrategic_after_question(id);
        } else {
        }
    },
    /**
     * تایید نهایی استراتژیک
     * @param {type} id
     * @returns {undefined}
     * 
     */
    confirmationFinalStrategic_after_question: function (id) {
        var param = "";
        param += "do=" + hmisStrategic.tableName + ".delete";
        param += "&" + hmisStrategic.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisStrategic.m_show_tbl();
    },
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisStrategic.tableName + ".select";
        param += "&" + hmisStrategic.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisStrategic.m_show_form();



    },
    m_add_EN: function (id) {
        var param = "";
        param += "do=" + hmisStrategic.tableName + ".add_EN";
        param += "&" + hmisStrategic.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisStrategic.f_parent).jjVal(id);
        new jj("#" + hmisStrategic.f_lang).jjVal("2");
        hmisStrategic.m_show_form();
    },
    m_add_Ar: function (id) {
        var param = "";
        param += "do=" + hmisStrategic.tableName + ".add_Ar";
        param += "&" + hmisStrategic.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisStrategic.f_parent).jjVal(id);
        new jj("#" + hmisStrategic.f_lang).jjVal("3");
        hmisStrategic.m_show_form();
    },
    //============ BY RASHIDI ========>
    m_add_Ln: function (id, langId) {
        var param = "";
        param += "do=" + hmisStrategic.tableName + ".add_lang";
        param += "&" + hmisStrategic.f_id + "=" + (id == null ? "" : id);
        param += "&myLang=" + (langId == null ? "1" : langId);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisStrategic.f_parent).jjVal(id);
        new jj("#" + hmisStrategic.f_lang).jjVal(langId);
//        alert(id+"&&&&&"+langId);
        hmisStrategic.m_show_form();
    },
    //<============ BY RASHIDI ========
    m_searchTextInTitle: function (text) {
        var param = "";
        param += "do=" + hmisStrategic.tableName + ".searchTextInTitle";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    m_searchTextInAll: function (text) {
        var param = "";
        param += "do=" + hmisStrategic.tableName + ".searchTextInAll";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    //============ BY RASHIDI ========>    
    m_searchTags: function () {
        var param = "";
        param += "do=" + hmisStrategic.tableName + ".searchTags";
        param += "&" + new jj('#swStrategicForm').jjSerial();
//        param += "&panel=content_search_tags_result";
        new jj(param).jjAjax2(false);
    },
    m_insertTags: function () {
        var param = "";
        param += "do=" + hmisStrategic.tableName + ".insertTags";
        param += "&" + new jj('#swStrategicForm').jjSerial();
//        param += "&panel=content_tags_div";
        new jj(param).jjAjax2(false);
    },
    //<============ BY RASHIDI ========    
    tabSizeTbl: function () {
        $('#swStrategic').css('height', 520);
    },
    tabSizeForm: function () {
        $('#swStrategic').css('height', 378);
    },
    validateInput: function (inputValue) {


        var inputNumber = /^[0-9]*$/;
        return inputNumber.test(inputValue);
    },
    regexInput: function (obj) {
        alert(obj);
        var inputValue = $(obj).val();
//        hmisStrategic.validateInput(inputValue);
        $(obj).attr('value', inputValue);
    },
    /**
     * آی دی یک جدول را میگیرد و برای محاسبه نهایی ریسک و اهمیت نقاط ضعف و قوت ستون های وزن آنها را نرمال می کند تا مجموع هر ستون صد بشود
     * @param {type} TableId
     * @returns {void}
     */
    normalizeTable: function (TableId) {
        var sum = 0;
        var fillInputNo = 0; //تعداد پر شده
        for (var j = 0; j < 10; j++) {//ستون ها
            for (var i = 0; i < 10; i++) {//سطرها
                var nextInput = $("#" + TableId + " tbody tr:eq(" + i + ") td.weith:eq(" + j + ") input"); //سطر آی ام ستون های جی ام و  اینپوت های داخل  آن را میگیرد
//                var inPutsInAllCol = $(nexttr).children("td input:nth-child(" + (i) + ")");                
                if ($(nextInput).size() == 1) {//اگر چنین عنصری پیدا شد
                    if ($(nextInput).val() != "" && $(nextInput).val() != "undefined" && $(nextInput) != null) {
                        sum += parseFloat($(nextInput).val());
                        fillInputNo++;
                    }
                }
            }
            for (var k = 0; k < 5; k++) {
                var dif = 100 - sum;
                var mul = dif / 100;
                sum = 0; //برای محاسبه مجموع جدید بعد از نرمال سازی
                for (var i = 0; i < 10; i++) {//سطرها
                    var nextInput = $("#" + TableId + " tbody tr:eq(" + i + ") td.weith:eq(" + j + ") input"); //چون ستون اول تکست اریا هست یک اضافه می کنیم
//                var inPutsInAllCol = $(nexttr).children("td input:nth-child(" + (i) + ")");
                    if ($(nextInput).size() == 1) {//اگر چنین عنصری پیدا شد
                        if ($(nextInput).val() != "" && $(nextInput).val() != "undefined" && $(nextInput) != null) {
                            var oldVal = parseFloat($(nextInput).val());
                            var newVal = oldVal + (oldVal * mul);
                            $(nextInput).attr('value', newVal);
                            sum += newVal;
                        }
                    }
                }
            }

            $(("#" + TableId + " .sumWeiths" + (j + 1))).attr('value', sum); //باید کلاسی مثل sumWeeiths1,2,3,... را داشته باشد
            mul = 1;
            sum = 0;
            hmisStrategic.calculteStrategicTable(TableId);
        }
//    var avgInput = $(this).parent().parent().find("input")[i];// خانه آخر 
//    $(avgInput).val(Math.round(sum / j));
//    for (var i = 1; i <= $("#tableFMEA1_4 tbody tr").length; i++) {// به تعداد سطر های جدول
//        var RPNresult = $("#tableFMEA1_1 tbody tr:nth-child(" + i + ") td:last-child input").val() * $("#tableFMEA1_2 tbody tr:nth-child(" + i + ")  td:last-child input").val() * $("#tableFMEA1_3 tbody tr:nth-child(" + i + ")  td:last-child input").val();
//        $("#tableFMEA1_4 tbody tr:nth-child(" + i + ") input:last-child").val(RPNresult);
//    }

    },
    calculteStrategicTable: function (TableId) {

        //میانگین وزن های هر سطر
        var sum = 0;
        var fillInputNo = 0; //تعداد پر شده
        for (var i = 0; i < 10; i++) {//سطرها
            for (var j = 0; j < 10; j++) {//ستون ها
                var nextInput = $("#" + TableId + " tbody tr:eq(" + i + ") td.weith:eq(" + j + ") input"); //سطر آی ام ستون های جی ام و  اینپوت های داخل  آن را میگیرد
//                var inPutsInAllCol = $(nexttr).children("td input:nth-child(" + (i) + ")");                
                if ($(nextInput).size() == 1) {//اگر چنین عنصری پیدا شد
                    if ($(nextInput).val() != "" && $(nextInput).val() != "undefined" && $(nextInput) != null) {
                        sum += parseFloat($(nextInput).val());
                        fillInputNo++;
                    }
                }
            }
            var avgWeith = parseFloat(sum / fillInputNo);
            if (isNaN(avgWeith)) {
                $("#" + TableId + " .avgWeith" + (i + 1)).attr('value', "0"); //باید کلاسی مثل avgWeith,2,3,... را داشته باشد
            } else {
                $("#" + TableId + " .avgWeith" + (i + 1)).attr('value', avgWeith); //باید کلاسی مثل avgWeith,2,3,... را داشته باشد

            }
//        var avgWithInput = $("#" + TableId + " tbody tr:eq(" + i + ") td.weith:eq(" + j + ") input");

            sum = 0;
            fillInputNo = 0;
        }
        //***********************************************
        //ماینگین رتبه های هر سطر
        var finalVal = 0;
        var sumFinalVal = 0;
        for (var i = 0; i < 10; i++) {//سطرها
            sum = 0;
            fillInputNo = 0; //تعداد پر شده
            for (var j = 0; j < 10; j++) {//ستون ها
                var nextInput = $("#" + TableId + " tbody tr:eq(" + i + ") td.value:eq(" + j + ") input"); //سطر آی ام ستون های جی ام و  اینپوت های داخل  آن را میگیرد
//                var inPutsInAllCol = $(nexttr).children("td input:nth-child(" + (i) + ")");                
                if ($(nextInput).size() == 1) {//اگر چنین عنصری پیدا شد
                    if ($(nextInput).val() != "" && $(nextInput).val() != "undefined" && $(nextInput) != null) {
                        sum += parseFloat($(nextInput).val());
                        fillInputNo++;
                    }
                }
            }
            var avgVals = parseFloat(sum / fillInputNo);
            if (isNaN(avgVals)) {
//            if (!avgVals.jjIsFloat()) {
//            $("#" + TableId + " .avgVals" + (i + 1)).attr('value', avgVals); //باید کلاسی مثل avgWeith,2,3,... را داشته باشد
//            if (!avgVals.jjIsFloat()) {
                $("#" + TableId + " .avgVals" + (i + 1)).attr('value', "0"); //باید کلاسی مثل avgWeith,2,3,... را داشته باشد
                finalVal = parseFloat("0") * parseFloat($("#" + TableId + " .avgWeith" + (i + 1)).val());

            } else {
                $("#" + TableId + " .avgVals" + (i + 1)).attr('value', avgVals); //باید کلاسی مثل avgWeith,2,3,... را داشته باشد
                finalVal = parseFloat($("#" + TableId + " .avgVals" + (i + 1)).val()) * parseFloat($("#" + TableId + " .avgWeith" + (i + 1)).val());


            }
            //محاسبه امتیاز نهایی هر سطر برابر با میانگین وزن ها در میانگین نمره ها

            $("#" + TableId + " .finalVal" + (i + 1)).attr('value', finalVal);

        }


        hmisStrategic.calculatorFinalVal(TableId);
    },
    calculatorFinalVal: function (TableId) {

        var sumFinalVal = 0;
        var length = $("#" + TableId + "   tr > td .finalVal").length;
        for (var i = 0; i < length; i++) {
            sumFinalVal += parseFloat($("#" + TableId + " td .finalVal" + (+i + 1)).val());

        }
        $("#" + TableId + " .sumFinalVal").attr('value', Math.round((sumFinalVal / 100)));


        $('div#pointer').css({'transform': 'translate(' + $('#tableIFE .sumFinalVal').val() * 55 + 'px' + ',' + $('#tableEFE .sumFinalVal').val() * (-57) + 'px' + ')'});
    },
    actionIconRemoveIFE: function (selector) {
        $(selector).parent().parent().find('input').addClass('red');
        $(selector).parent().parent().find('input').removeClass('green');
        var temp1 = $('#IFETbl  td input.red');
        var temp2 = '';
        for (var i = 0; i < temp1.length; i++) {
            temp2 += $(temp1[i]).val() + '/';
        }
        $('.weaknessIFE').attr('value', temp2);
    },
    actionIconAddIFE: function (selector) {

        $(selector).parent().parent().find('input').addClass('green');
        $(selector).parent().parent().find('input').removeClass('red');
        var temp1 = $('#IFETbl  td input.green');
        var temp2 = '';
        for (var i = 0; i < temp1.length; i++) {
            temp2 += $(temp1[i]).val() + '\n';
        }
        $('.chanceIFE').attr('value', temp2);
    },
    actionIconRemoveEFE: function (selector) {
        $(selector).parent().parent().find('input').addClass('red');
        $(selector).parent().parent().find('input').removeClass('green');
        var temp1 = $('#EFETbl  td input.red');
        var temp2 = '';
        for (var i = 0; i < temp1.length; i++) {
            temp2 += $(temp1[i]).val() + '\n';
        }
        $('.weaknessEFE').attr('value', temp2);
    },
    actionIconAddEFE: function (selector) {
        $(selector).parent().parent().find('input').addClass('green');
        $(selector).parent().parent().find('input').removeClass('red');
        var temp1 = $('#EFETbl  td input.green');
        var temp2 = '';
        for (var i = 0; i < temp1.length; i++) {
            temp2 += $(temp1[i]).val() + '\n';
        }
        $('.chanceEFE').attr('value', temp2);
    },
    actionIconRemoveQSPM: function (selector) {
        $(selector).parent().parent().find('input').addClass('red');
        $(selector).parent().parent().find('input').removeClass('green');
        var temp1 = $('#tableQSPM  td input.red');
        var temp2 = '';
        for (var i = 0; i < temp1.length; i++) {
            temp2 += $(temp1[i]).val() + '\n';
        }
//        $('.weaknessEFE').attr('value', temp2);
    },
    actionIconAddQSPM: function (selector) {
        $(selector).parent().parent().find('input').addClass('green');
        $(this).parent().parent().find('input').removeClass('red');
        var temp1 = $('#tableQSPM  td input.green');
        var temp2 = '';
        for (var i = 0; i < temp1.length; i++) {
            temp2 += $(temp1[i]).val() + '//n';
        }
    },
    addRowIFE: function () {

        var length = 0;
        length = $("#tableIFE #IFETbl tr.rowIFE").length + 1;
        var tr = ("<tr class='rowIFE'><td><input class='form-control onkeyup' placeholder='' style='height: 40px'/><span><i class='ion-android-add actionIconAdd' style='color:green;margin:2px 2px;cursor: pointer'    onclick='hmisStrategic.actionIconAddIFE($(this));'></i><i class='ion-android-remove actionIconRemove' style='margin:2px 2px;cursor: pointer'    onclick='hmisStrategic.actionIconRemoveIFE($(this));'  ></i></span></td>\n\
<td class='weith'><input class='form-control is-valid onkeyup' type='text' value=''/>\n\
</td><td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  />\n\
</td><td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input class='form-control is-valid onclick' min='-4' max='4' type='number' value=''  /></td>\n\
                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input class='form-control is-valid onclick' min='-4' max='4' type='number' value=''  /></td>\n\
                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value='' /></td>\n\
                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input class='form-control is-valid onclick' min='-4' max='4' type='number' value=''  /></td>\n\
                                        <td class='weith'><input  class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input  class='form-control is-valid onclick' min='-4' max='4' type='number' value='' /></td>\n\
                                        <td class='weith'><input  class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input  class='form-control is-valid onclick' min='-4' max='4' type='number' value='' /></td>\n\
                                        <td class=''><input  class='form-control is-valid avgWeith" + length + "  onkeyup'  type='text' value=''  /></td>\n\
                                        <td class=''><input  class='form-control is-valid avgVals" + length + " onkeyup'  type='text' value=''   /></td>\n\
                                        <td class=''><input  class='finalVal form-control is-valid finalVal" + length + " onkeyup'  type='text' value=''  /></td>\n\
                                    </tr>");
        $("#tableIFE #IFETbl tr.rowIFE:last").after(tr);
    },
//    addColIFE: function () {
//
//        var length = 0;
//        length = ($("#tableIFE #IFETbl  td.thTdIFE").length + 2) / 2;
//        var tr1 = ("<td class='c thTdIFE'>وزن " + length + "</td>\n\
//                   <td class='c thTdIFE'>رتبه" + length + "</td>");
//        var tr2 = ("<td class='weith' id='td" + length + "'><input  type='text'  class='form-control is-valid onkeyup' value='' /></td>\n\
//                            <td class='value'  id='td" + length + "'><input  class='form-control is-valid onclick'  min='-4' max='4'   type='number' value='' /></td>")
//        $("#tableIFE #IFETbl  td.thTdIFE:last").after(tr1);
//        $("#tableIFE #IFETbl tbody > tr.rowIFE td").after(tr2);
//
//    },
    addRowEFE: function () {
        var length = 0;
        length = $("#tableEFE #EFETbl tr.rowEFE").length + 1;
        var tr = ("<tr class='rowEFE' ><td><input class='form-control onkeyup' placeholder='' style='height: 40px'/><span><i class='ion-android-add actionIconAdd' style='color:green;margin:2px 2px;cursor: pointer'    onclick='hmisStrategic.actionIconAddIFE($(this));'></i><i class='ion-android-remove actionIconRemove' style='margin:2px 2px;cursor: pointer'    onclick='hmisStrategic.actionIconRemoveIFE($(this));'  ></i></span></td>\n\
<td class='weith'><input class='form-control is-valid onkeyup' type='text' value=''   /></td><td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td><td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input class='form-control is-valid onclick' min='-4' max='4' type='number' value=''  /></td>\n\
                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input class='form-control is-valid onclick' min='-4' max='4' type='number' value=''  /></td>\n\
                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value='' /></td>\n\
                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input class='form-control is-valid onclick' min='-4' max='4' type='number' value=''  /></td>\n\
                                        <td class='weith'><input  class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input  class='form-control is-valid onclick' min='-4' max='4' type='number' value='' /></td>\n\
                                        <td class='weith'><input  class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
                                        <td class='value'><input  class='form-control is-valid onclick' min='-4' max='4' type='number' value='' /></td>\n\
                                        <td class=''><input  class='form-control is-valid avgWeith" + length + "  onkeyup'  type='text' value=''  /></td>\n\
                                        <td class=''><input  class='form-control is-valid avgVals" + length + " onkeyup'  type='text' value=''   /></td>\n\
                                        <td class=''><input  class='finalVal form-control is-valid finalVal" + length + " onkeyup'  type='text' value=''  /></td>\n\
                                    </tr>");
        $("#tableEFE #EFETbl tr.rowEFE:last").after(tr);
    },
//    addColEFE: function () {
//        var length = 0;
//        length = $("#tableEFE #EFETbl tr.rowEFE").length + 1;
//        var tr = ("<tr class='rowEFE' ><td><input class='form-control onkeyup' placeholder='' style='height: 40px'/><span><i class='ion-android-add actionIconAdd' style='color:green;margin:2px 2px;cursor: pointer'    onclick='hmisStrategic.actionIconAddIFE($(this));'></i><i class='ion-android-remove actionIconRemove' style='margin:2px 2px;cursor: pointer'    onclick='hmisStrategic.actionIconRemoveIFE($(this));'  ></i></span></td>\n\
//<td class='weith'><input class='form-control is-valid onkeyup' type='text' value=''   /></td><td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td><td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
//                                        <td class='value'><input class='form-control is-valid onclick' min='-4' max='4' type='number' value=''  /></td>\n\
//                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
//                                        <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
//                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
//                                        <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
//                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
//                                        <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
//                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
//                                        <td class='value'><input class='form-control is-valid onclick' min='-4' max='4' type='number' value=''  /></td>\n\
//                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
//                                        <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value='' /></td>\n\
//                                        <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
//                                        <td class='value'><input class='form-control is-valid onclick' min='-4' max='4' type='number' value=''  /></td>\n\
//                                        <td class='weith'><input  class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
//                                        <td class='value'><input  class='form-control is-valid onclick' min='-4' max='4' type='number' value='' /></td>\n\
//                                        <td class='weith'><input  class='form-control is-valid onkeyup'  type='text' value=''   /></td>\n\
//                                        <td class='value'><input  class='form-control is-valid onclick' min='-4' max='4' type='number' value='' /></td>\n\
//                                        <td class=''><input  class='form-control is-valid avgWeith" + length + "  onkeyup'  type='text' value=''  /></td>\n\
//                                        <td class=''><input  class='form-control is-valid avgVals" + length + " onkeyup'  type='text' value=''   /></td>\n\
//                                        <td class=''><input  class='form-control is-valid finalVal" + length + " onkeyup'  type='text' value=''  /></td>\n\
//                                    </tr>");
//        $("#tableEFE #EFETbl tr.rowEFE:last").after(tr);
//    },
    /**
     * add سطر
     * @returns {undefined}
     */
    addRowTablePrioritized: function () {
        $("#tablePrioritized").append("<tr><td><input type='text' class='form-control is-valid  onkeyup' placeholder='' style='height: 40px' >\n\
</td><td class='weith' style='width: 120px'>\n\
<input class='form-control is-valid'  type='text' value='' /></td> </tr>");
    },
    addRowTableQSPM: function () {
        $("#tableQSPM").append("<tr>\n\
                            <td><input class='form-control onkeyup' placeholder='' style='height: 40px'/><span>\n\
                            <i class='ion-android-add  actionIconAdd' style='color:green;margin:2px 2px;cursor: pointer'   onclick='hmisStrategic.actionIconAddQSPM($(this));' ></i>\n\
                            <i class='ion-android-remove actionIconRemove' style='margin:2px 2px;cursor: pointer'    onclick='hmisStrategic.actionIconRemoveQSPM($(this));'  ></i>\n\
                            </span></td>\n\
                            <td class='weith' style='width: 120px'><input class='form-control is-valid onkeyup'  type='text' value='' /></td>\n\
                            <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
                            <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value='' /></td>\n\
                            <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
                            <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value='' /></td>\n\
                            <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
                            <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value='' /></td>\n\
                            <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
                            <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value='' /></td>\n\
                            <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
                            <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value='' /></td>\n\
                            <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
                            <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value='' /></td>\n\
                            <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
                            <td class='weith'><input class='form-control is-valid onkeyup'  type='text' value='' /></td>\n\
                            <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
                            <td class='value'><input class='form-control is-valid onclick'  min='-4' max='4' type='number' value=''  /></td>\n\
</tr>");
    },
    removeRowTableQSPM: function () {
        if ($("#tableQSPM tr").length > 1) {
            $("#tableQSPM tr").last().remove();
        }
    },
    removeRowTablePrioritized: function () {
        if ($("#tablePrioritized tr").length > 1) {
            $("#tablePrioritized tr").last().remove();
        }
    },
    removeRowEFE: function () {
        if ($("#tableEFE #EFETbl tr.rowEFE").length > 1) {
            $("#tableEFE #EFETbl tr.rowEFE").last().remove();
        }
    },
    pointerMove: function () {
        var position = $("table#SWOTMatrixTable tr td#zeroPoint").position();
        var x = position.left + 'px';
        var y = position.top + 'px';
        alert(x + "," + y);
        $('#pointer').css({'transform': 'translate(' + x + ', ' + y + ')'});

    },
    /**
     * حذف سطر
     * @returns {undefined}
     */
    removeRowIFE: function () {
        if ($("#tableIFE #IFETbl tr.rowIFE").length > 1) {

            $("#tableIFE #IFETbl tr.rowIFE").last().remove();
        } else {
        }
    }
}
var hmisStrategicGuide = {
    tableName: "",
    f_id: "id",
    loadForm: function () {
        if ($("#swStrategicGuideForm").html() == '') {
            $("#swStrategicGuideForm").load("formHMIS/09FMEA.html", null, function () {

//                $("#cancel_StrategicGuide").click(function (e) {
//                    hmisStrategic.m_clean();
                hmisStrategicGuide.m_show_form();
//                })
//                hmisStrategic.m_refresh();
            });
        }
    },
    m_show_form: function () {
//        $('#swStrategicGuideTbl').slideUp();
        $('#swStrategicGuideForm').slideDown();
        hmisStrategic.tabSizeForm();
    },
    m_clean: function () {
        new jj('#swStrategicGuideForm').jjFormClean();
    },
//    m_add_new: function () {
//        var param = "";
//        param += "&do=" + hmisStrategic.tableName + ".add_new&jj=1";
//        new jj(param).jjAjax2(false);
//        hmisStrategic.m_clean();
////        hmisStrategic.m_show_form();
//        $('#swStrategicGuideForm').show();
////        $('#swStrategicGuideTbl').hide();
//        //        oEditor.execCommand( 'bold');
//
//    },
//    m_show_tbl: function () {
////        $('#swStrategicGuideTbl').show();
////        $('#swStrategicGuideForm').hide();
////        if ($('#swStrategicGuideTbl').html() == "") {
////            hmisStrategic.m_refresh();
////        }
////        hmisStrategic.tabSizeTbl();
//    },

    //<============ BY RASHIDI ========    

    tabSizeTbl: function () {
        $('#swStrategicGuide').css('height', 520);
    },
    tabSizeForm: function () {
        $('#swStrategicGuide').css('height', 378);
    },
}
;
