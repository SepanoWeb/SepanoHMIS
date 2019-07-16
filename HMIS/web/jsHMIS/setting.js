var hmisSetting = {
    tableName : "Setting",
    f_id :"id",
 
    loadForm:function(){
        if($("#swSettingForm").html()==''){
            $("#swSettingForm").load("formHMIS/0setting.html", null, function(){
                $("#cancel_setting").click(function(e) {
                    hmisSetting.m_clean();
                    hmisSetting.m_show_tbl();
                });

            });
        }
    }, 
    m_refresh:function(containerId, sortField, tableHeight){
        var param = "";
        param += "do="+hmisSetting.tableName+".refresh";
        param += "&panel=" + (containerId==null ? "swSettingTbl" : containerId);
        param += "&sort=" + (sortField==null ? "0" : sortField);
        param += "&height=" + (tableHeight==null ? PanelHeight : tableHeight);
       new jj(param).jjAjax2(false);
        hmisSetting.tabSizeTbl();
    },
    m_show_form:function(){
        $('#swSettingTbl').hide();
        $('#swSettingForm').show();
        hmisSetting.tabSizeForm();
    },
    m_clean:function(){
        new jj("#swSettingForm").jjFormClean();
       
    },
    m_show_tbl:function(){
        $('#swSettingTbl').show();
        $('#swSettingForm').hide();
        hmisSetting.m_refresh();
        hmisSetting.tabSizeTbl();
    },
     m_add_new: function () {
        new jj("&do=" + hmisSetting.tableName + ".add_new").jjAjax2(false);
        hmisSetting.m_show_form();
        hmisSetting.m_clean();

    },
    m_insert:function(){
        var param = "";
        param += "do="+hmisSetting.tableName+".insert";
        param += "&" + new jj("#swSettingForm").jjSerial();
       new jj(param).jjAjax2(false);
        hmisSetting.m_show_tbl();
        hmisSetting.m_clean();
    }, 
    m_edit:function(){
        var param = "";
        param += "do="+hmisSetting.tableName+".edit";
        param += "&" + new jj("#swSettingForm").jjSerial();
         new jj(param).jjAjax2(false);
        hmisSetting.m_show_tbl();
        hmisSetting.m_clean();
    }, 
    m_delete:function(id){
       if (confirm("از حذف رکورد اطمینان دارید؟")) {
                hmisSetting.m_delete_after_question(id);
            } else {
            }
    }, 
    m_delete_after_question:function(id){
        var param = "";
        param += "do="+hmisSetting.tableName+".delete";
        param += "&" + hmisSetting.f_id + "=" + (id==null ? "" : id);
         new jj(param).jjAjax2(false);
        hmisSetting.m_show_tbl();
        hmisSetting.m_clean();
    },
    m_select:function(id){
        var param = "";
        param += "do="+hmisSetting.tableName+".select";
        param += "&" + hmisSetting.f_id + "=" + (id==null ? "" : id);
        new  jj(param).jjAjax2(false);
        hmisSetting.m_show_form();
        
    },
    m_getMenu:function(){
        var param = "";
        param += "do="+hmisSetting.tableName+".getMenu";
        new  jj(param).jjAjax2(false);
    },
    tabSizeTbl: function () {
        $('#swSetting').css('height',515);
        hmisSetting.heightTab=515;
    },
    tabSizeForm: function () {
        $('#swSetting').css('height',270);
        hmisSetting.heightTab=270;
    },
    heightTab:"515",
    mainTabSetSize : function () {
        $('#swSetting').css('height',hmisSetting.heightTab);
    }
}

