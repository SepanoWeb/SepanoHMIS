/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var hmisPlans = {
    tableName: "Plans",
    f_id: "id",
    loadForm: function () {
        if ($("#swPlansForm").html() == '') {
            $("#swPlansForm").load("formHMIS/04newPlan.html", null, function () {
                $("#cancel_Plans").button().click(function (e) {
                    hmisPlans.m_clean();
                    hmisPlans.m_show_tbl();
                });
                new jj("#steps_startDate").jjCalendarWithYearSelector(1340, 1420);
                new jj("#steps_endDate").jjCalendarWithYearSelector(1340, 1420);
                //////////////////////////////
//                $("#sendFileTajhizat").button().click(function () {
//                });
//                $("#upload_tajhizat_file2").button().click(function () {
//                });
//                new jj('#sendFileTajhizat').jjAjaxFileUpload('#upload_tajhizat_file2', '#tajhizat_file', '#tajhizatFilePreview');
//                $('#tajhizat_file').keyup(function () {
//                    $('#tajhizatFilePreview').attr('src', 'upload/' + $('#tajhizat_file').val());
//                    if ($('#tajhizat_file').val() == '') {
//                        $('#tajhizatFilePreview').attr('src', 'img/preview.jpg');
//                    }
//                });



                /////////////////////////////
                $("#sendFile1Steps").button().click(function () {
                });
                $("#upload_file1_steps").click(function () {
                });
                new jj('#sendFile1Steps').jjAjaxFileUpload('#upload_file1_steps', '#steps_file1', '#StepsPicPreview');
                $('#steps_file1').keyup(function () {
                    $('#StepsPicPreview').attr('src', 'upload/' + $('#steps_file1').val());
                    if ($('#steps_file1').val() == '') {
                        $('#StepsPicPreview').attr('src', 'img/preview.jpg');
                    }
                });
//                $(function () {
//                    'use strict';
//                    $('#refreshPlans').DataTable({
//                        responsive: true,
//                        language: {
//                            searchPlaceholder: 'جستجو...',
//                            sSearch: '',
//                            lengthMenu: '_MENU_ items/page',
//                        }
//                    });
//
//
//                    // Select2
//                    $('.dataTables_length select').select2({minimumResultsForSearch: Infinity});
//
//                });
//                new jj("#upload_Content").jjAjaxFileUploadEditor('#upload_Content_file', content_content_editor);
//                $("#upload_Content_file").button().click(function () {
//                });
                //============ BY RASHIDI ========>
//                $("#content_insert_tags").button().click(function (e) {
//                    $("#" + cmsContent.f_tags).val($("#" + cmsContent.f_tags).val() + $("#tags_name").val() + ',');//تگ نوشته شده را به یک اینپوت مخفی اضافه می کند
//                   cmsContent.m_insertTags();
//
//                });
//               $('#tags_name').keyup(function () {
//                    if ($("#tags_name").val() === "") {
//                       $("#content_search_tags_result").hide();
//                   }
//                   cmsContent.m_searchTags();
//               });
                hmisPlans.m_refresh();
            });
        }
    },
//    m_refresh: function () {
    m_refresh: function (containerId, sortField, tableHeight) {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".refresh";
        param += "&panel=" + (containerId == null ? "swPlansTbl" : containerId);
        param += "&sort=" + (sortField == null ? "0" : sortField);
        param += "&height=" + (tableHeight == null ? 800 : tableHeight);
        param += "&jj=1";
        new jj(param).jjAjax2(false);
//        himsPlan.tabSizeTbl();
    },
    m_show_form: function () {
        $('#swPlansTbl').hide();
        $('#swPlansForm').show();
        hmisPlans.tabSizeForm();
    },
    m_clean: function () {
        new jj('#hmis_plans_id').jjVal("");
        new jj('#hmis_steps_id').jjVal("");
        new jj('#stepsForm').jjFormClean();
        new jj('#newFormPlans').jjFormClean();
        $('#refreshTblSteps').html("");
        $("#btn_editSteps").hide(); //پنهان کردن دکمه ثبت تغییرات گام
        $("#btn_insertSteps").show(); // نمایش دکمه ثبت گام
        $("#btn_addNewSteps").show(); //نمایش دکمه گام جدید


//        new jj("#tags_name").jjVal("");
//        new jj(content_content_editor).jjEditorVal("");
//        $("#Content_Language_button").hide();
    },
    m_add_new: function () {
        jj("do=" + hmisPlans.tableName + ".add_new&jj=1").jjAjax2(false);
        hmisPlans.m_show_form();
        $('#recordPlans').show(); //مخفی کردن دکمه ثبت 
        $('#newFormPlans').show(); //مخفی کردن فرم پلن 
        $('#stepsForm').hide(); //فرم گام
        $('#editPlansButton').hide(); ///ثبت تغییرات پلن
        $('#formQuestions').hide(); //
        hmisPlans.m_clean();
        //        oEditor.execCommand( 'bold');

    },
    m_show_tbl: function () {
        $('#swPlansTbl').show();
        $('#swPlansForm').hide();
        if ($('#swPlansTbl').html() == "") {
            hmisPlans.m_refresh();
        }
        hmisPlans.m_refresh();
        hmisPlans.tabSizeTbl();
    },
    m_insert: function () {
//        var valid = hmisPlans.m_validation();
//        if (valid == "") {
        var param = "";  
        param += "do=" + hmisPlans.tableName + ".insert";
        param += "&" + new jj('#swPlansForm').jjSerial();
        new jj(param).jjAjax2(false);
//        hmisPlans.m_show_tbl();
//        hmisPlans.m_clean();
//        } else {
//            new jj(valid).jjDialog();
//        }
        $('#formQuestions').show(); //نمایش گام ها 
        $('#stepsForm').show(); //نمایش گام ها 
        $('#recordPlans').hide(); //مخفی کردن دکمه ثبت 
    },
    m_edit: function () {
//        var valid = hmisPlan.m_validation();
//        if (valid == "") {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".edit";
        param += "&" + new jj('#swPlansForm').jjSerial();
        param += "&jj=1";
        new jj(param).jjAjax2(false);
        hmisPlans.m_show_tbl();
        hmisPlans.m_clean();
//        } else {
//            new jj(valid).jjDialog();
//        }
    },
    /**
     * ویرایش اطلاعات گام ها در قسمت plans
     * 
     * @returns {undefined}
     */
    editStepsInPlans: function () {

        var param = "";
        param += "do=" + hmisPlans.tableName + ".editStepsInPlans";
        param += "&" + new jj('#stepsForm').jjSerial();
        param += "&jj=1";
        new jj(param).jjAjax2(false);
    },
//    m_validation: function () {// mohamdad
//        if (new jj("#content_title").jjVal().length < 1) {
//            return "فیلد عنوان نباید کوچکتر از دو کاراکتر باشد";
//        }
//        return "";
//    },
    m_delete: function (id) {
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('hmisPlans.m_delete_after_question(' + id + ');\n', true, "");
    },
    m_delete_after_question: function (id) {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".delete";
        param += "&" + hmisPlans.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisPlans.m_show_tbl();
        hmisPlans.m_clean();
    },
    /**
     * 13971115
     * @param {type} id
     * @returns {undefined}
     */
    m_select: function (id) {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".select";
        param += "&" + hmisPlans.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisPlans.m_show_form();
        $('#formQuestions').show(); //نمایش گام ها 
        $('#newFormPlans').hide(); //نمایش گام ها 
        $('#editPlansButton').show(); //نمایش دکمه تغییرات
        $('#stepsForm').show(); //نمایش فرم گامها
        $('#correctionForm').hide(); // فرم اصلاحیه 


    },
    /**
     * 13971116
     * @param {type} id
     * @returns {undefined}
     */
    selectStepsInPlans: function (id) {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".selectStepsInPlans";
        param += "&" + hmisPlans.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        hmisPlans.m_show_form();
        $('#formQuestions').show(); //نمایش گام ها 
        $('#newFormPlans').hide(); //نمایش گام ها 
        $('#editPlansButton').show(); //نمایش دکمه تغییرات
        $('#stepsForm').show(); //
        $("html, body").delay(1000).animate({scrollTop: $('#stepsForm').offset().top}, 800);
    },
    /**
     * نمایش فرم اصلاحیه 
     * تاریخ ایجاد
     * 13971117
     * @param {type} id
     * ای دی برنامه
     * @returns {undefined}
     */

    correctionPlans: function () {
        $('#correctionForm').show();
    },
    actionReferral: function () {
        new jj("آیا از ارجاع اطمینان دارید؟").jjDialog_YesNo('hmisPlans.afterActionReferral();\n', true, "");

    },
    /**
     * ارجاع به ایجاد کننده
     * 13971117
     * @returns {undefined}
     */
    afterActionReferral: function () {
        var param = "";
        param += "&hmis_plans_id=" + new jj('#hmis_plans_id').jjVal();
        param += "&" + new jj('#correctionForm').jjSerial();
        param += "&do=" + hmisPlans.tableName + ".referral";
        new jj(param).jjAjax2(false);
    },

    m_add_EN: function (id) {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".add_EN";
        param += "&" + hmisPlans.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisPlans.f_parent).jjVal(id);
        new jj("#" + hmisPlans.f_lang).jjVal("2");
        hmisPlans.m_show_form();
    },
    /**
     * تایید توسط مافوق
     * @param {type} id
     * @returns {undefined}
     */
    confirmBySuperwizar: function (id) {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".confirmBySuperwizar";
        param += "&" + hmisPlans.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
    },
    m_add_Ar: function (id) {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".add_Ar";
        param += "&" + hmisPlans.f_id + "=" + (id == null ? "" : id);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisPlans.f_parent).jjVal(id);
        new jj("#" + hmisPlans.f_lang).jjVal("3");
        hmisPlans.m_show_form();
    },
    //============ BY RASHIDI ========>
    m_add_Ln: function (id, langId) {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".add_lang";
        param += "&" + hmisPlans.f_id + "=" + (id == null ? "" : id);
        param += "&myLang=" + (langId == null ? "1" : langId);
        new jj(param).jjAjax2(false);
        new jj("#" + hmisPlans.f_parent).jjVal(id);
        new jj("#" + hmisPlans.f_lang).jjVal(langId);
//        alert(id+"&&&&&"+langId);
        hmisPlans.m_show_form();
    },
    //<============ BY RASHIDI ========
    m_searchTextInTitle: function (text) {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".searchTextInTitle";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    m_searchTextInAll: function (text) {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".searchTextInAll";
        param += "&text=" + (text == null ? "" : text);
        new jj(param).jjAjax2(false);
    },
    //============ BY RASHIDI ========>    
    m_searchTags: function () {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".searchTags";
        param += "&" + new jj('#swPlansForm').jjSerial();
//        param += "&panel=content_search_tags_result";
        new jj(param).jjAjax2(false);
    },
    m_insertTags: function () {
        var param = "";
        param += "do=" + hmisPlans.tableName + ".insertTags";
        param += "&" + new jj('#swPlansForm').jjSerial();
//        param += "&panel=content_tags_div";
        new jj(param).jjAjax2(false);
    },
    //<============ BY RASHIDI ========    
    tabSizeTbl: function () {
        $('#swPlans').css('height', 520);
    },
    tabSizeForm: function () {
        $('#swPlans').css('height', 378);
    }
//    mainTabSetSize: function () {
////        var aa = $("#swContent").children();
////        var bb = 0;
////        for(i=0; i < aa.length; i++){  
////            if($(aa[i]).css("display")!='none'){
////                bb+= new jj($(aa[i]).css("height")).jjConvertToInt() ;
////            }
////        }
////        if(bb==0){
////            $('#tabs').css('height',572);
////        }else{
////            $('#tabs').css('height',bb+44);
////        }
//    }
};
//============ BY RASHIDI ========> 
//function selectSearchResult(selectedTagNo) {
//    $("#tags_name").val($("#tagsResult_td" + selectedTagNo).html());
//    $("#content_search_tags_result").hide();
//}

//function deleteContentTag(deletedTagNo) {
//    new jj("آیا از حذف این برچسب اطمینان دارید؟").jjDialog_YesNo('afterDeleteContentTag(' + deletedTagNo + ');\n', true, "");
//}
//function afterDeleteContentTag(deletedTagNo) {
//
////    var myString = $("#" + cmsContent.f_tags).val();
////    var oldWord = $("#contetn_tag_span" + deletedTagNo).html().toString();
////    var reg = new RegExp(oldWord, "g");
////    myString = myString.replace(reg, "");
////    alert(myString);
//
//    var str = $("#" + cmsContent.f_tags).val();
//    var tagName = $("#contetn_tag_span" + deletedTagNo).html().toString();
//    var reg = new RegExp(tagName, "g");
//    str = str.replace(reg, "");
//    $("#" + cmsContent.f_tags).val(str);
//    $("#contetn_tag_span" + deletedTagNo).remove();
//}
//<============ BY RASHIDI ========  