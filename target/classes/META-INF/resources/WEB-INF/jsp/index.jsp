<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:700">
    <link rel="stylesheet" href="css/index.css">

    <title>Acronym / Mnemonic Generator</title>
  </head>
  <body>
    <div class="container-fluid text-center header-container">
      <div class="card header-card">
        <h1>Acronym / Mnemonic Generator</h1>
      </div>
    </div>

    <div class="container-fluid text-center body-container">
      <div class="container text-center body-card-container">
        <div class="card body-card">
          <h1> Input </h1>

          <form name="word-form" id="word-form" onsubmit="return validate();">
            <table class="table" id="dynamic-field">
              <tr>
                <td>
                  <input type="text" name="word" id="word" class="form-control word_list" placeholder="Word">
                </td>

                <td>
                  <button type="button" class="btn orange-button" name="add" id="add">Add Row</button>
                </td>
              </tr>
            </table>

            <button type="button" class="btn orange-button" name="generate" id="generate"> Generate </button>
          </form>
        </div>
      </div>
    </div>

    <!-- jQuery, popper, bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <script>
      $(document).ready(function() {
        var rows = 1;
        $('#add').click(function() {
          rows++;
          $('#dynamic-field').append('<tr id="row'+rows+'"><td><input type="text" name="word" id="word" class="form-control word_list" placeholder="Word"></td><td><button type="button" class="btn btn_danger btn_remove" name="remove" id="'+rows+'">X</button></td></tr>');
        });
        $(document).on('click', '.btn_remove', function() {
          var button_id = $(this).attr("id");
          $("#row"+button_id+"").remove();
        });
        $('#generate').click(function() {
          var words = new String();
          
          $("input").each(function(index) {
            if($(this).val() != "")
            {
              words = words + $(this).val() + "\n";
            }
            console.log($(this).val());
          });

          console.log(words);

          $.ajax({ 
            url:"/api/",
            type:"POST", 
            contentType: "text/plain",
            data: words,
            async: false,
            cache: false,
            accept: "application/json",
            processData:false,
            success: function(resposeJsonObject){
              alert(resposeJsonObject);
            }
          });
        });
      });
    </script>
  </body>
</html>
