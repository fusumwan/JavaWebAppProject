
$( document ).ready(function() {
	document.getElementById("banner").className="banner banner_small"
    document.getElementById("search-container").style.display="none";
    
    
	var UserSession=app.domain.utils.GetUserSession();
	if(UserSession==undefined || UserSession.account_id==""){
	    alert("Please kindly login our OrderTable account system!");
	    window.location=contextPath+"/login";
	}
	
	
	
    var GridViewContainerID="subject_sentenceGridViewContainer";
    if(GridViewContainerID!=undefined && GridViewContainerID!=""){
        var DataBindList=[
			{
				TableName:"subject_sentence",
				OnDataBound:function(e){
					var instance={
						setting:e
					};
					let pkCondition="";
					var PageSession=app.domain.utils.GetPageSession();
					if(instance.setting.ParentRowData!=undefined && instance.setting.ParentRowData!=null &&
					instance.setting.ParentDataKeyNames!=undefined && instance.setting.ParentDataKeyNames!=null){
						for(var i=0;i<instance.setting.ParentDataKeyNames.length>0;i++){
							if(pkCondition!=""){
								pkCondition+=" AND ";
							}
							let ParentDataKeyName=instance.setting.ParentDataKeyNames[i];
							let ParentDataKeyValue=instance.setting.ParentRowData[ParentDataKeyName];
                            if(app.domain.utils.Value.isNumeric(ParentDataKeyValue)){
								pkCondition+=ParentDataKeyName+"="+ParentDataKeyValue;
							}else{
								pkCondition+=ParentDataKeyName+"='"+ParentDataKeyValue+"'";
							}
						}
						if(pkCondition!=""){
							pkCondition=" AND "+pkCondition;
						}
					}
					
					var situation_condition="";
					var event_condition="";
					var sentence_type_condition="";
					if (PageSession.index.search_criteria_1!=undefined){
						if (PageSession.index.search_criteria_1!=""){
							situation_condition = " AND situation='"+PageSession.index.search_criteria_1+"'";
						}
					}
					if (PageSession.index.search_criteria_2!=undefined){
						if (PageSession.index.search_criteria_2!=""){
							event_condition = " AND event='"+PageSession.index.search_criteria_2+"'";
						}
					}
					if (PageSession.index.search_criteria_3!=undefined){
						if (PageSession.index.search_criteria_3!=""){
							sentence_type_condition = " AND sentence_type='"+PageSession.index.search_criteria_3+"'";
							$("#sentence_type_txt").val(PageSession.index.search_criteria_3);
						}
					}
					return app.domain.repositories.search.filter("subject_sentence","subject_sentence_id IS NOT NULL"+ pkCondition+situation_condition+event_condition+sentence_type_condition);
					
				}
			}
		];
	    var GridView=app.controllers.ui.result.SubjectSentenceGridViewControl.init({
			ID:GridViewContainerID,
            ParentRowData: null,
			contextPath:window.contextPath,
            DataBindList:DataBindList
		});
		GridView.DataBind();
	}
});
        