/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var hmisPart = {
    tableName : "Part",
    f_id :"id",
    
    loadForm:function(){
        if($("#swPartForm").html()==''){
            $("#swPartForm").load("formHMIS/part.html", null, function(){
                 hmisPart.m_refresh();
//                   hmisPart.m_show_form();
                $("#cancel_Part").button().click(function(e) {
                    hmisPart.m_clean();
                    hmisPart.m_show_tbl();
                });
                $("#sendEmailBtn").button().click(function(e) {
                    sendEmailForComment();
                });
                
            });
        }
    }, 
    m_refresh:function(containerId, sortField, tableHeight){
        var param = "";
        param += "do="+hmisPart.tableName+".refresh";
        param += "&panel=" + (containerId==null ? "swPartTbl" : containerId);
        param += "&sort=" + (sortField==null ? "0" : sortField);
        param += "&height=" + (tableHeight==null ? PanelHeight : tableHeight);
        param += "&jj=1" ;
        jj(param).jjAjax2(false);
        hmisPart.tabSizeTbl();
    },
    m_show_form:function(){
        $('#swPartTbl').hide();
        $('#swPartForm').show();
        hmisPart.tabSizeForm();
    },
    m_clean:function(){
        new jj("#swPartForm").jjFormClean();
       
    },
    m_show_tbl:function(){
        $('#swPartTbl').show();
        $('#swPartForm').hide();
        hmisPart.m_refresh();
        hmisPart.tabSizeTbl();
    },
    m_insert:function(){
        var param = "";
        param += "do="+hmisPart.tableName+".insert";
        param += "&" + new jj("#swPartForm").jjSerial();
        jj(param).jjAjax2(false);
        hmisPart.m_show_tbl();
        hmisPart.m_clean();
    }, 
    m_edit:function(){
        var param = "";
        param += "do="+hmisPart.tableName+".edit";
        param += "&" + new jj("#swPartForm").jjSerial();
        jj(param).jjAjax2(false);
        hmisPart.m_show_tbl();
        hmisPart.m_clean();
    }, 
    m_delete:function(id){
        new jj("آیا از حذف این رکورد اطمینان دارید؟").jjDialog_YesNo('hmisPart.m_delete_after_question('+id+');\n', true, "");
    }, 
    m_delete_after_question:function(id){
        var param = "";
        param += "do="+hmisPart.tableName+".delete";
        param += "&" + hmisPart.f_id + "=" + (id==null ? "" : id);
        jj(param).jjAjax2(false);
        hmisPart.m_show_tbl();
        hmisPart.m_clean();
    },
    m_select:function(id){
        var param = "";
        param += "do="+hmisPart.tableName+".select";
        param += "&" + hmisPart.f_id + "=" + (id==null ? "" : id);
        jj(param).jjAjax2(false);
        hmisPart.m_show_form();
        
    },
    m_getMenu:function(){
        var param = "";
        param += "do="+hmisPart.tableName+".getMenu";
        jj(param).jjAjax2(false);
    },
    tabSizeTbl: function () {
        $('#swPart').css('height',515);
        hmisPart.heightTab=515;
    },
    tabSizeForm: function () {
        $('#swPart').css('height',270);
        hmisPart.heightTab=270;
    },
    heightTab:"515",
    mainTabSetSize : function () {
        $('#swPart').css('height',hmisPart.heightTab);
    }
}


