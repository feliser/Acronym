var words = new Array();
      var request = '';
      function setCharAt(str,index,chr) {
        if(index > str.length-1) return str;
        return str.substr(0,index) + chr.toUpperCase() + str.substr(index+1);
      }
      $(document).ready(function() {
        var rows = 1;
        addRow();
        addRow();
        $('#add').click(function() {
          addRow();
        });
        $(document).on('click', '.btn_remove', function() {
          var button_id = $(this).attr("id");
          $("#row"+button_id+"").remove();
        });
        $('#generate').click(function() {
          document.getElementById("response").textContent = "";
          request = "";
          words = [];
          $("input").each(function(index) {
            if($(this).val() != "") {
              words.push($(this).val());
              request += $(this).val() + " ";
            }
          });          
          var wordsJSON = "{\"request\": " + JSON.stringify(words) + "}";
          var xmlhttp = new XMLHttpRequest();
		  xmlhttp.onreadystatechange = function() {
  		  	if (this.readyState == 4 && this.status == 200) {
              var object = JSON.parse(this.responseText);
              $('#response-card').css('visibility', 'visible');
              var bold = document.createElement
              object.response.forEach(function (item, index) {
                var tr = document.createElement('tr');
                tr.appendChild( document.createElement('td') );
				var element = document.createElement('p');
				element.innerHTML = ('<h3>' + item.word + '</h3>');
                tr.cells[0].appendChild(element);
                tr.cells[0].appendChild(getBreakdown(item.boldIndices));
                var table = document.getElementById('response');
                table.appendChild(tr);
              });
              if (object.response.length == 0) {
                var tr = document.createElement('tr');
                tr.appendChild( document.createElement('td') );
				var element = document.createElement('p');
				element.innerHTML = ('<h3>' + "No Acronyms Found" + '</h3>');
                tr.cells[0].appendChild(element);
                var table = document.getElementById('response');
                table.appendChild(tr);
              }
          	}
		  };
		  xmlhttp.open("POST", "generate", true);
		  xmlhttp.setRequestHeader("Content-type", "application/json");
		  xmlhttp.send(wordsJSON);
        });
        function addRow() {
          rows++;
          $('#dynamic-field').append('<tr id="row'+rows+'"><td><input type="text" name="word" id="word" class="form-control word_list" placeholder="Term"></td><td><button type="button" class="btn btn_danger btn_remove" name="remove" id="'+rows+'">Remove</button></td></tr>');
        }
      });
      function getBreakdown(boldIndices) {
        var element = document.createElement('p');
        var response = request;
        boldIndices.forEach(function (item, index) {
          response = setCharAt(response, item + (26 * index), '<font color=#FF750>' + response.charAt(item + (26 * index)) + '</font>');
        });
        element.innerHTML = response;
        return element;
      }