$( document ).ready(function() { 
    document.getElementById("banner").className="banner banner_small"
    document.getElementById("search-container").style.display="none";
    
    var UserSession=app.domain.utils.GetUserSession();
    if(UserSession==undefined || UserSession.account_id==""){
        alert("Please kindly login our OrderTable account system!");
        window.location=contextPath+"/login";
    }
    
    $("#csvUploadForm").submit(function(e){
        var fileName = $("#subject_sentence_upload_file").val();
        var fileSize = $("#subject_sentence_upload_file")[0].files[0].size;
        var maxSize = 5 * 1024 * 1024; // 5 MB in bytes

        if(fileName == "") {
            e.preventDefault();
            alert("Please select a file to upload.");
        } else if (fileSize > maxSize) {
            e.preventDefault();
            alert("File size should not be greater than 5MB.");
        }
    });
    
    $('.custom-file-input').on('change', function() { 
        let fileName = $(this).val().split('\\').pop(); 
        $(this).siblings('.custom-file-label').addClass("selected").html(fileName); 
    });
}); 

function showDialog() {
    $("<div>Upload Success!</div>").dialog({
        title: "Success",
        modal: true,
        buttons: {
            Ok: function() {
                $(this).dialog("close");
            }
        }
    });
}
