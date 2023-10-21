
window["app.controllers.ui.result"] = {
	SubjectSentenceGridViewControl: {
        init(setting) {
            const instance = {
                setting: {
					ID: "",
					ParentRowData: null,
					ParentDataKeyNames: null,
                    ParentControl:null,
                    contextPath: null,
                    DataBindList: null
                },
                ObjectDataSource:null,
                GridView:null
            };
            if (setting) {
                if (setting.contextPath == undefined){ setting.contextPath=window.contextPath; }
                Object.assign(instance.setting, setting);
                instance.ObjectDataSource = app.controllers.ui.ObjectDataSource.init({
                    ID: instance.setting.ID+"DS",
                    Runat: window.contextPath,
                    SelectControl: "subject_sentence",
                    InsertMethod: "create-json",
                    SelectMethod: "retrieve-json",
                    UpdateMethod: "update-json",
                    DeleteMethod: "delete-json",
                    TypeName: "subject_sentence",
                    OnDataBound: GetOnDataBound(setting),
                    ParentRowData:instance.setting.ParentRowData,
                    ParentDataKeyNames: instance.setting.ParentDataKeyNames,
                    Async: false
                });

                function GetOnDataBound(setting){
					if (setting.DataBindList==null || setting.DataBindList==undefined){
						return subject_sentenceDataBound;
					}else{
						for(var i=0;i<setting.DataBindList.length;i++){
							OnDataBindJson=setting.DataBindList[i];
							if (OnDataBindJson.TableName=="subject_sentence"){
								return OnDataBindJson.OnDataBound;
							}
						}
					}
					return subject_sentenceDataBound;
				}

                function subject_sentenceDataBound(e){
                    var instance={
						setting:e
					};
					let pkCondition="";
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
					return app.domain.repositories.search.filter("subject_sentence","subject_sentence_id IS NOT NULL"+ pkCondition);
				}

                const GridViewConfig = {
                    ID: instance.setting.ID,
                    Runat: window.contextPath,
                    AutoGenerateColumns: true,
                    DataKeyNames: ["subject_sentence_id"],
                    ObjDataSource: instance.ObjectDataSource,
                    AllowPaging: true,
                    PageSize: 10,
                    DialogSize: 1.3,
                    OnRowDetailDataBound:subject_sentenceOnRowDetailDataBound,
                    ParentRowData:instance.setting.ParentRowData,
                    ParentDataKeyNames: instance.setting.ParentDataKeyNames,
                    ParentControl:instance.setting.ParentControl,
                    OnCreateButtonRenderContent:subject_sentenceOnCreateButtonRenderContent,
                    AllowSorting: true
                };

                function subject_sentenceOnCreateButtonRenderContent(e){
                    createButtonHtml= '<input class="' + e.CreateButtonClassName + ' btn btn-primary" type="button" value="Create" style="display:none"/><br><br>';
					return createButtonHtml;
                }

                function subject_sentenceOnRowDetailDataBound(e){
					var RowData = e.RowData;
					var GridView = e.GridView;
			        var tableName = "";
			        var ctableName = "";
			        var htmlCode = "";
		            var row = e.row;
		            var detail_container_id=GridView.ID+"_dh_"+e.pkId;
		            var detail_container_tbl_id=GridView.ID+"_dh_tbl_"+e.pkId;
                    var ParentDataKeyNames=[];
		            ParentDataKeyNames.push(e.pkName);
		            objDataSource=methods.ObjDataSource();
			        if (objDataSource != null) {
			            tableName = objDataSource.TypeName;
			            ctableName = objDataSource.TypeName.charAt(0).toUpperCase() + objDataSource.TypeName.slice(1);
			        }
			        htmlCode += '<table id="'+detail_container_tbl_id+'" cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;display:none">'
			        for (let i = 0; i < GridView.Columns.length; i++) {
			            const column = GridView.Columns[i];
			            if (column.DataField != "" && 
			            column.DataField != null && 
			            column.HeaderText != "" && 
			            column.HeaderText != null && 
			            column.DetailDisplayable!=false) {
			                const inputType = GridView.InputTypeSearchBy(column.DataField);
			                if (inputType == "file") {
			                    htmlCode += '<tr>';
			                    htmlCode += '<td>' + column.HeaderText + ':</td>';
			                    htmlCode += '<td>';
			                    htmlCode += '<img src=' + "data:image/jpeg;base64," + RowData[column.DataField] + ' style="width: 100px;height: 100px;">';
			                    htmlCode += '</td>';
			                    htmlCode += '</tr>';
			                } else {
			                    htmlCode += '<tr>';
			                    htmlCode += '<td>' + column.HeaderText + ':</td>';
			                    htmlCode += '<td>';
			                    htmlCode += RowData[column.DataField];
			                    htmlCode += '</td>';
			                    htmlCode += '</tr>';
			                }
			            }
			        }
			        htmlCode += '</table>';
			        
			        row.child('<div id="'+detail_container_id+'"></div>').show();
			        $("#"+detail_container_id).append(htmlCode);
			        $("#"+detail_container_tbl_id).css("display","inline");
                    $("#"+detail_container_tbl_id).css("padding-left","0px");
                    
			        return htmlCode;
				}

                instance.GridView = app.controllers.ui.GridView.init(GridViewConfig);
                instance.GridView.Columns.push(
                    app.controllers.ui.BoundField.init({
                        NullDisplayText: "",
                        Orderable:false,
                        Searchable:false,
                        ClassName:"",
                        DefaultContent:"",
                        Targets:0
                    }),
                    app.controllers.ui.BoundField.init({
                        NullDisplayText: "no data",
                        Orderable:false,
                        Searchable:false,
                        ClassName:"details-control",
                        DefaultContent:"+",
                        Targets:1
                    }),

					app.controllers.ui.BoundField.init({
						DataField: "subject_sentence_id",
						HeaderText: "subject_sentence_id",
						SortExpression: "subject_sentence_id",
						HtmlInputSetting: {"type": "hidden"},
						ReadOnly: true,
						RetrieveDisplayable:false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data"
					}),
					app.controllers.ui.BoundField.init({
						DataField: "situation",
						HeaderText: "situation",
						SortExpression: "situation",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data"
					}),
					app.controllers.ui.BoundField.init({
						DataField: "event",
						HeaderText: "event",
						SortExpression: "event",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data"
					}),
					app.controllers.ui.BoundField.init({
						DataField: "sentence_type",
						HeaderText: "sentence_type",
						SortExpression: "sentence_type",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "article_01",
						HeaderText: "article_01",
						SortExpression: "article_01",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "subject_01",
						HeaderText: "subject_01",
						SortExpression: "subject_01",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "conjunction_01",
						HeaderText: "conjunction_01",
						SortExpression: "conjunction_01",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "adverb_01",
						HeaderText: "adverb_01",
						SortExpression: "adverb_01",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "auxiliary_verb_01",
						HeaderText: "auxiliary_verb_01",
						SortExpression: "auxiliary_verb_01",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "verb_01",
						HeaderText: "verb_01",
						SortExpression: "verb_01",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "infinitive_01",
						HeaderText: "infinitive_01",
						SortExpression: "infinitive_01",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "conjunction_02",
						HeaderText: "conjunction_02",
						SortExpression: "conjunction_02",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "adverb_02",
						HeaderText: "adverb_02",
						SortExpression: "adverb_02",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "preposition_01",
						HeaderText: "preposition_01",
						SortExpression: "preposition_01",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "pronoun_01",
						HeaderText: "pronoun_01",
						SortExpression: "pronoun_01",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "article_02",
						HeaderText: "article_02",
						SortExpression: "article_02",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "adjective_01",
						HeaderText: "adjective_01",
						SortExpression: "adjective_01",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "noun_01",
						HeaderText: "noun_01",
						SortExpression: "noun_01",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "noun_phase_01",
						HeaderText: "noun_phase_01",
						SortExpression: "noun_phase_01",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "gerund_01",
						HeaderText: "gerund_01",
						SortExpression: "gerund_01",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "preposition_02",
						HeaderText: "preposition_02",
						SortExpression: "preposition_02",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "clause_01",
						HeaderText: "clause_01",
						SortExpression: "clause_01",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "full_sentence",
						HeaderText: "full_sentence",
						SortExpression: "full_sentence",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:false
					}),
					app.controllers.ui.BoundField.init({
						DataField: "traditional_chinese",
						HeaderText: "traditional_chinese",
						SortExpression: "traditional_chinese",
						HtmlInputSetting: {"type": "text"},
						ReadOnly: false,
						ClassName:instance.GridView.InputClassName,
						NullDisplayText: "no data",
						RetrieveDisplayable:true
					}),

                    app.controllers.ui.BoundField.init({
                        DataField: "subject_sentence_id",
                        NullDisplayText: "no data",
                        Orderable:false,
                        Searchable:false,
                        RetrieveDisplayable:true,
                        Render:function(data){
                            return '<button class="'+instance.GridView.UpdateButtonClassName+' btn btn-info" data-pkName="subject_sentence_id" data-id="' + data + '">Update</button>' +
                            '<button class="'+instance.GridView.DeleteButtonClassName+' btn btn-danger" data-pkName="subject_sentence_id" data-id="' + data + '">Delete</button>';
                        }
                    })
                );

                var subject_sentenceFormView=instance.GridView.GetFormView();
        
                subject_sentenceFormView.setItem(app.controllers.ui.ItemTemplate.init({
                    RenderContent: function(e) {
                        var html = ''+
                        '<table id="'+e.ID+'">'+
                        '<tbody>'+
                        
                        '<tr>'+
                        '<td><label  class="form-label" for="subject_sentence_id">subjectsentenceid</label></td>'+
                        '<td>'+
                        
                        '<input id="subject_sentence_id" name="subject_sentence_id" readonly="readonly" class="'+e.InputClassName+'" type="hidden">'+
                
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="situation">situation</label></td>'+
                        '<td>'+
                        
                        '<input name="situation" id="situation" class="'+e.InputClassName+' form-input margin-bottom" placeholder="situation" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="event">event</label></td>'+
                        '<td>'+
                        
                        '<input name="event" id="event" class="'+e.InputClassName+' form-input margin-bottom" placeholder="event" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="sentence_type">sentencetype</label></td>'+
                        '<td>'+
                        
                        '<input name="sentence_type" id="sentence_type" class="'+e.InputClassName+' form-input margin-bottom" placeholder="sentence_type" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="article_01">article01</label></td>'+
                        '<td>'+
                        
                        '<input name="article_01" id="article_01" class="'+e.InputClassName+' form-input margin-bottom" placeholder="article_01" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="subject_01">subject01</label></td>'+
                        '<td>'+
                        
                        '<input name="subject_01" id="subject_01" class="'+e.InputClassName+' form-input margin-bottom" placeholder="subject_01" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="conjunction_01">conjunction01</label></td>'+
                        '<td>'+
                        
                        '<input name="conjunction_01" id="conjunction_01" class="'+e.InputClassName+' form-input margin-bottom" placeholder="conjunction_01" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="adverb_01">adverb01</label></td>'+
                        '<td>'+
                        
                        '<input name="adverb_01" id="adverb_01" class="'+e.InputClassName+' form-input margin-bottom" placeholder="adverb_01" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="auxiliary_verb_01">auxiliaryverb01</label></td>'+
                        '<td>'+
                        
                        '<input name="auxiliary_verb_01" id="auxiliary_verb_01" class="'+e.InputClassName+' form-input margin-bottom" placeholder="auxiliary_verb_01" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="verb_01">verb01</label></td>'+
                        '<td>'+
                        
                        '<input name="verb_01" id="verb_01" class="'+e.InputClassName+' form-input margin-bottom" placeholder="verb_01" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="infinitive_01">infinitive01</label></td>'+
                        '<td>'+
                        
                        '<input name="infinitive_01" id="infinitive_01" class="'+e.InputClassName+' form-input margin-bottom" placeholder="infinitive_01" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="conjunction_02">conjunction02</label></td>'+
                        '<td>'+
                        
                        '<input name="conjunction_02" id="conjunction_02" class="'+e.InputClassName+' form-input margin-bottom" placeholder="conjunction_02" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="adverb_02">adverb02</label></td>'+
                        '<td>'+
                        
                        '<input name="adverb_02" id="adverb_02" class="'+e.InputClassName+' form-input margin-bottom" placeholder="adverb_02" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="preposition_01">preposition01</label></td>'+
                        '<td>'+
                        
                        '<input name="preposition_01" id="preposition_01" class="'+e.InputClassName+' form-input margin-bottom" placeholder="preposition_01" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="pronoun_01">pronoun01</label></td>'+
                        '<td>'+
                        
                        '<input name="pronoun_01" id="pronoun_01" class="'+e.InputClassName+' form-input margin-bottom" placeholder="pronoun_01" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="article_02">article02</label></td>'+
                        '<td>'+
                        
                        '<input name="article_02" id="article_02" class="'+e.InputClassName+' form-input margin-bottom" placeholder="article_02" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="adjective_01">adjective01</label></td>'+
                        '<td>'+
                        
                        '<input name="adjective_01" id="adjective_01" class="'+e.InputClassName+' form-input margin-bottom" placeholder="adjective_01" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="noun_01">noun01</label></td>'+
                        '<td>'+
                        
                        '<input name="noun_01" id="noun_01" class="'+e.InputClassName+' form-input margin-bottom" placeholder="noun_01" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="noun_phase_01">nounphase01</label></td>'+
                        '<td>'+
                        
                        '<input name="noun_phase_01" id="noun_phase_01" class="'+e.InputClassName+' form-input margin-bottom" placeholder="noun_phase_01" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="gerund_01">gerund01</label></td>'+
                        '<td>'+
                        
                        '<input name="gerund_01" id="gerund_01" class="'+e.InputClassName+' form-input margin-bottom" placeholder="gerund_01" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="preposition_02">preposition02</label></td>'+
                        '<td>'+
                        
                        '<input name="preposition_02" id="preposition_02" class="'+e.InputClassName+' form-input margin-bottom" placeholder="preposition_02" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="clause_01">clause01</label></td>'+
                        '<td>'+
                        
                        '<input name="clause_01" id="clause_01" class="'+e.InputClassName+' form-input margin-bottom" placeholder="clause_01" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="full_sentence">fullsentence</label></td>'+
                        '<td>'+
                        
                        '<input name="full_sentence" id="full_sentence" class="'+e.InputClassName+' form-input margin-bottom" placeholder="full_sentence" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td><label  class="form-label" for="traditional_chinese">traditionalchinese</label></td>'+
                        '<td>'+
                        
                        '<input name="traditional_chinese" id="traditional_chinese" class="'+e.InputClassName+' form-input margin-bottom" placeholder="traditional_chinese" type="text" pattern="">'+
                        '</td>'+
                        '</tr>'+
            
                        '<tr>'+
                        '<td colspan="2">'+
                        '<input class="'+e.InputClassName+' btn btn-primary" id="'+e.SubmitButtonClassName+'" name="'+e.SubmitButtonClassName+'" type="button" value="Submit">'+
                        '</td>'+
                        '</tr>'+
                        '</tbody>'+
                        '</table>';
                        $("#" + e.ContainerID).append(html);
                        return html;
                    }
                })).ItemTemplateSaveUpdateClick(function(e) {
                    const container = $("#" + e.ID);
                    if (container.length > 0) {
                            var InputClassName = e.InputClassName;
                            var GridView=e.ParentControl;
                            var formData = new FormData();
                            
                                if($('#' + "situation" + "." + InputClassName).val()==""){ alert("Please kindly input situation!");return;}
                                if($('#' + "event" + "." + InputClassName).val()==""){ alert("Please kindly input event!");return;}
                                if($('#' + "sentence_type" + "." + InputClassName).val()==""){ alert("Please kindly input sentence_type!");return;}
                                if($('#' + "article_01" + "." + InputClassName).val()==""){ alert("Please kindly input article_01!");return;}
                                if($('#' + "subject_01" + "." + InputClassName).val()==""){ alert("Please kindly input subject_01!");return;}
                                if($('#' + "conjunction_01" + "." + InputClassName).val()==""){ alert("Please kindly input conjunction_01!");return;}
                                if($('#' + "adverb_01" + "." + InputClassName).val()==""){ alert("Please kindly input adverb_01!");return;}
                                if($('#' + "auxiliary_verb_01" + "." + InputClassName).val()==""){ alert("Please kindly input auxiliary_verb_01!");return;}
                                if($('#' + "verb_01" + "." + InputClassName).val()==""){ alert("Please kindly input verb_01!");return;}
                                if($('#' + "infinitive_01" + "." + InputClassName).val()==""){ alert("Please kindly input infinitive_01!");return;}
                                if($('#' + "conjunction_02" + "." + InputClassName).val()==""){ alert("Please kindly input conjunction_02!");return;}
                                if($('#' + "adverb_02" + "." + InputClassName).val()==""){ alert("Please kindly input adverb_02!");return;}
                                if($('#' + "preposition_01" + "." + InputClassName).val()==""){ alert("Please kindly input preposition_01!");return;}
                                if($('#' + "pronoun_01" + "." + InputClassName).val()==""){ alert("Please kindly input pronoun_01!");return;}
                                if($('#' + "article_02" + "." + InputClassName).val()==""){ alert("Please kindly input article_02!");return;}
                                if($('#' + "adjective_01" + "." + InputClassName).val()==""){ alert("Please kindly input adjective_01!");return;}
                                if($('#' + "noun_01" + "." + InputClassName).val()==""){ alert("Please kindly input noun_01!");return;}
                                if($('#' + "noun_phase_01" + "." + InputClassName).val()==""){ alert("Please kindly input noun_phase_01!");return;}
                                if($('#' + "gerund_01" + "." + InputClassName).val()==""){ alert("Please kindly input gerund_01!");return;}
                                if($('#' + "preposition_02" + "." + InputClassName).val()==""){ alert("Please kindly input preposition_02!");return;}
                                if($('#' + "clause_01" + "." + InputClassName).val()==""){ alert("Please kindly input clause_01!");return;}
                                if($('#' + "full_sentence" + "." + InputClassName).val()==""){ alert("Please kindly input full_sentence!");return;}
                                if($('#' + "traditional_chinese" + "." + InputClassName).val()==""){ alert("Please kindly input traditional_chinese!");return;}
                            // 添加其他表單字段
                            formData.append("_method", "PUT"); // 模擬 PUT 請求
                            
                            formData.append("subject_sentence_id", $('#' + "subject_sentence_id" + "." + InputClassName).val());
                            formData.append("situation", $('#' + "situation" + "." + InputClassName).val());
                            formData.append("event", $('#' + "event" + "." + InputClassName).val());
                            formData.append("sentence_type", $('#' + "sentence_type" + "." + InputClassName).val());
                            formData.append("article_01", $('#' + "article_01" + "." + InputClassName).val());
                            formData.append("subject_01", $('#' + "subject_01" + "." + InputClassName).val());
                            formData.append("conjunction_01", $('#' + "conjunction_01" + "." + InputClassName).val());
                            formData.append("adverb_01", $('#' + "adverb_01" + "." + InputClassName).val());
                            formData.append("auxiliary_verb_01", $('#' + "auxiliary_verb_01" + "." + InputClassName).val());
                            formData.append("verb_01", $('#' + "verb_01" + "." + InputClassName).val());
                            formData.append("infinitive_01", $('#' + "infinitive_01" + "." + InputClassName).val());
                            formData.append("conjunction_02", $('#' + "conjunction_02" + "." + InputClassName).val());
                            formData.append("adverb_02", $('#' + "adverb_02" + "." + InputClassName).val());
                            formData.append("preposition_01", $('#' + "preposition_01" + "." + InputClassName).val());
                            formData.append("pronoun_01", $('#' + "pronoun_01" + "." + InputClassName).val());
                            formData.append("article_02", $('#' + "article_02" + "." + InputClassName).val());
                            formData.append("adjective_01", $('#' + "adjective_01" + "." + InputClassName).val());
                            formData.append("noun_01", $('#' + "noun_01" + "." + InputClassName).val());
                            formData.append("noun_phase_01", $('#' + "noun_phase_01" + "." + InputClassName).val());
                            formData.append("gerund_01", $('#' + "gerund_01" + "." + InputClassName).val());
                            formData.append("preposition_02", $('#' + "preposition_02" + "." + InputClassName).val());
                            formData.append("clause_01", $('#' + "clause_01" + "." + InputClassName).val());
                            formData.append("full_sentence", $('#' + "full_sentence" + "." + InputClassName).val());
                            formData.append("traditional_chinese", $('#' + "traditional_chinese" + "." + InputClassName).val());

                            var method = "POST";
                            var Runat = e.Runat;
                            var tableName = "subject_sentence";
                            var controllerMethod = (e.Mode=="CREATE")?"create":"update";
                            var url = ""
                            if(Runat!="" && Runat!=undefined){
                                url += Runat;
                            }
                            if(tableName!="" && tableName!=undefined){
                                url += "/" + tableName+ "/" + controllerMethod;
                            }
                            $.ajax({
                                url: url,
                                type: method,
                                dataType: "json",
                                data: formData,
                                processData: false,
                                contentType: false,
                                headers: app.domain.utils.JWT.headers("FORMDATA"),
                                async: false,
                                success: function(data) {
                                    
                                    data=app.domain.utils.JWT.json_process_jwt(data);
                                    if(e.Mode=="CREATE"){
                                        alert(tableName + ' created successfully');
                                        GridView.CreateRecord(data);
                                    }else{
                                        alert(tableName + ' updated successfully');
                                        GridView.UpdateRecord(data);
                                    }
                                    GridView.ClearFormDiv();
                                    GridView.CloseFormViewDialog();
                                    GridView.ObjDataSource.DataBind(methods);
                                    //GridView.DataBind();
            
                                },
                                error: function(xhr, status, error) {
                                    alert('An error occurred while creating the ' + tableName);
                                    console.log(xhr.responseText);
                                }
                            });
                        }
                    }).ItemTemplateRetrieveLoad(function(e) {
                        var e=e;
                        const container = $("#" + e.ID);
                        if (container.length > 0 && e.DataKeyValue!="") {
                            var formData = new FormData();
                            // add other form fields
                            formData.append("_method", "PUT"); // Simulate a PUT request
                            formData.append("subject_sentence_id", e.DataKeyValue);
                            var method = "POST";
                            var Runat = e.Runat;
                            var tableName = "subject_sentence";
                            var getMethod = "get";
                            var url = ""
                            if(Runat!="" && Runat!=undefined){
                                url += Runat;
                            }
                            if(tableName!="" && tableName!=undefined){
                                url += "/" + tableName+ "/" + getMethod;
                            }
                            $.ajax({
                                url: url,
                                type: method,
                                dataType: "json",
                                data: formData,
                                processData: false,
                                contentType: false,
                                headers: app.domain.utils.JWT.headers("FORMDATA"),
                                async: false,
                                success: function(data) {
                                    data=app.domain.utils.JWT.json_process_jwt(data);
                                    
                                $("#" + "subject_sentence_id"+ "." + e.InputClassName).val(data["subject_sentence_id"]);
                                $("#" + "situation"+ "." + e.InputClassName).val(data["situation"]);
                                $("#" + "event"+ "." + e.InputClassName).val(data["event"]);
                                $("#" + "sentence_type"+ "." + e.InputClassName).val(data["sentence_type"]);
                                $("#" + "article_01"+ "." + e.InputClassName).val(data["article_01"]);
                                $("#" + "subject_01"+ "." + e.InputClassName).val(data["subject_01"]);
                                $("#" + "conjunction_01"+ "." + e.InputClassName).val(data["conjunction_01"]);
                                $("#" + "adverb_01"+ "." + e.InputClassName).val(data["adverb_01"]);
                                $("#" + "auxiliary_verb_01"+ "." + e.InputClassName).val(data["auxiliary_verb_01"]);
                                $("#" + "verb_01"+ "." + e.InputClassName).val(data["verb_01"]);
                                $("#" + "infinitive_01"+ "." + e.InputClassName).val(data["infinitive_01"]);
                                $("#" + "conjunction_02"+ "." + e.InputClassName).val(data["conjunction_02"]);
                                $("#" + "adverb_02"+ "." + e.InputClassName).val(data["adverb_02"]);
                                $("#" + "preposition_01"+ "." + e.InputClassName).val(data["preposition_01"]);
                                $("#" + "pronoun_01"+ "." + e.InputClassName).val(data["pronoun_01"]);
                                $("#" + "article_02"+ "." + e.InputClassName).val(data["article_02"]);
                                $("#" + "adjective_01"+ "." + e.InputClassName).val(data["adjective_01"]);
                                $("#" + "noun_01"+ "." + e.InputClassName).val(data["noun_01"]);
                                $("#" + "noun_phase_01"+ "." + e.InputClassName).val(data["noun_phase_01"]);
                                $("#" + "gerund_01"+ "." + e.InputClassName).val(data["gerund_01"]);
                                $("#" + "preposition_02"+ "." + e.InputClassName).val(data["preposition_02"]);
                                $("#" + "clause_01"+ "." + e.InputClassName).val(data["clause_01"]);
                                $("#" + "full_sentence"+ "." + e.InputClassName).val(data["full_sentence"]);
                                $("#" + "traditional_chinese"+ "." + e.InputClassName).val(data["traditional_chinese"]);
                                },
                                error: function(xhr, status, error) {
                                    alert('An error occurred while loading the ' + tableName);
                                    console.log(xhr.responseText);
                                }
                            });
                        }
                    })
        
            }
            
            const methods = {
                DataBind(){
                    if(instance.GridView!=null && instance.GridView!=undefined){
                        return instance.GridView.DataBind();
                    }
                },
                DataSource(){
                    if(instance.GridView!=null && instance.GridView!=undefined){
                        return instance.GridView.ObjDataSource.DataSource;
                    }
                },
                ObjDataSource(){
					if(instance.GridView!=null && instance.GridView!=undefined){
                        return instance.GridView.ObjDataSource;
                    }
				},
				SetObjDataSource(obj){
					if(instance.GridView!=null && instance.GridView!=undefined){
                        return instance.GridView.ObjDataSource=obj
                    }
				}
            };
            return methods;
        }
    }
            }
function appControllersResultUI(){
    if(window.app!=undefined && window.app!=null){
		if(!window.app.hasOwnProperty("controllers")){
			if(window["app.controllers"]!=undefined){
				window.app["controllers"]=window["app.controllers"];
			}
		}
		if(!window.app.controllers.hasOwnProperty("ui")){
			if(window["app.controllers.ui"]!=undefined){
				window.app.controllers["ui"]=window["app.controllers.ui"];
			}else{
				window.app.controllers["ui"]={}
			}
		}
		if(!window.app.controllers.ui.hasOwnProperty("result")){
			if(window["app.controllers.ui.result"]!=undefined){
				window.app.controllers.ui["result"]=window["app.controllers.ui.result"];
			}else{
				window.app.controllers.ui["result"]={}
			}
		}
	}
}
$( document ).ready(function() {
    appControllersResultUI();
});
        