<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "obuca";

$conn = mysqli_connect($servername, $username, $password, $dbname);

?>

<!DOCTYPE html>
<html>
<head>
   <title>DataTable</title>
    <meta charset="UTF-8">
    <meta name="description" content="Otvoreno računarstvo - lab2">
    <meta name="keywords" content="HTML, JavaScript, PHP, mySQL">
    <meta name="author" content="Edin Ibranović">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js">
   </script>
   <script>
      $(document).ready(function() {

      function exportTableToCSV($table, filename) {

      var $rows = $table.find('tr:has(td)'),
         tmpColDelim = String.fromCharCode(11),
         tmpRowDelim = String.fromCharCode(0), 
         colDelim = '","',
         rowDelim = '"\r\n"',
         csv = '"' + $rows.map(function(i, row) {
            var $row = $(row),
            $cols = $row.find('td');
            return $cols.map(function(j, col) {
            var $col = $(col),
               text = $col.text();
            return text.replace(/"/g, '""'); 
            }).get().join(tmpColDelim);
         }).get().join(tmpRowDelim)
         .split(tmpRowDelim).join(rowDelim)
         .split(tmpColDelim).join(colDelim) + '"';

      if (false && window.navigator.msSaveBlob) {

         var blob = new Blob([decodeURIComponent(csv)], {
            type: 'text/csv;charset=utf8'
         });
         window.navigator.msSaveBlob(blob, filename);

      } else if (window.Blob && window.URL) {
         var blob = new Blob([csv], {
            type: 'text/csv;charset=utf-8'
         });
         var csvUrl = URL.createObjectURL(blob);

         $(this)
            .attr({
            'download': filename,
            'href': csvUrl
            });
      } else {
         var csvData = 'data:application/csv;charset=utf-8,' + encodeURIComponent(csv);

         $(this)
            .attr({
            'download': filename,
            'href': csvData,
            'target': '_blank'
            });
         }
      }
      $(".export").on('click', function(event) {
      var args = [$('#obuca>table'), 'export.csv'];
      exportTableToCSV.apply(this, args);
      });
   });
   </script>
</head>
<body>
   <div>
      <form id="form">
      <label for="pretraga">Pretrazi: </label>
      <input type="search" id="pretraga" name="pretraga" placeholder="Cekam unos..." aria-label="Search through site content"><br>
      <label for="filter">Filter: </label>
      <select name="filter" id="filterelementi">
      <option value="wildcard">Sva polja (wildcard)</option>
      <option value="marka">Marka</option>
      <option value="model">Model</option>
      <option value="spol">Spol</option>
      <option value="velicina">Velicina</option>
      <option value="godina">Godina proizvodnje</option>
      <option value="materijal">Materijal</option>
      <option value="vrsta">Vrsta</option>
      <option value="visina">Visina dona</option>
      <option value="tip">Tip zatvaranja</option>
      </select>
      <br>
      <button>OK</button>
      </form>
   </div>
   <br><br>
   <div id="obuca">
      <?php
         $br = "";
         $sql = "select * from obuca";
         $result = mysqli_query($conn, $sql);
         echo "<table border='1' id=tableData>
         <tr>
         <th>ID</th>
         <th>Marka</th>
         <th>Model</th>
         <th>Spol</th>
         <th>Velicina</th>
         <th>Godina proizvodnje</th>
         <th>Materijal</th>
         <th>Vrsta</th>
         <th>Visina dona</th>
         <th>Tip zatvaranja</th>
         </tr>";
         while ($row = mysqli_fetch_assoc($result)) {
            $br = $row['id'];
            echo "<tr id=red$br>";
            echo "<td id=id$br>" . $row['id'] . "</td>";
            echo "<td id=marka$br>" . $row['marka'] . "</td>";
            echo "<td id=model$br>" . $row['model'] . "</td>";
            echo "<td id=spol$br>" . $row['spol'] . "</td>";
            echo "<td id=velicina$br>" . $row['velicina'] . "</td>";
            echo "<td id=godina$br>" . $row['godProizvodnje'] . "</td>";
            echo "<td id=materijal$br>" . $row['materijal'] . "</td>";
            echo "<td id=vrsta$br>" . $row['vrsta'] . "</td>";
            echo "<td id=visina$br>" . $row['visinaDona'] . "</td>";
            echo "<td id=tip$br>" . $row['tipZatvaranja'] . "</td>";
            echo "</tr>";
         }
         echo "</table>";
      ?>
   </div><br>
   <button><a href="#" class="export">CSV</a></button>
   <br><br>
   <button id="dl-json">JSON</button>
   <script>
   function tableToJson(table) {
         var data = [];
         var headers = [];
         for (var i=0; i<table.rows[0].cells.length; i++) {
            headers[i] = table.rows[0].cells[i].innerHTML.toLowerCase().replace(/ /gi,'');
         }
         for (var i=1; i<table.rows.length; i++) {
            var tableRow = table.rows[i];
            var rowData = {};
            for (var j=1; j<tableRow.cells.length; j++) {
               rowData[ headers[j] ] = tableRow.cells[j].innerHTML;
            }
            data.push(rowData);
         }
         return data;
      }
      var myjson = JSON.stringify(tableToJson(document.getElementById("tableData")));
      
      function downloadObjectAsJson(exportObj, exportName) {
         var dataStr = "data:text/json;charset=utf-8," + encodeURIComponent(exportObj);
         var node = document.createElement('a');
         node.setAttribute("href", dataStr);
         node.setAttribute("download", exportName + ".json");
         node.click();
         node.remove();
      }

      document.getElementById('dl-json').onclick = function() {
         downloadObjectAsJson(myjson, 'obuca');
      }
      const f=document.getElementById('form');
      function submitted(event) {
         event.preventDefault(); 
         var q = document.getElementById('pretraga');
         var val = q.value;
         var ftr = document.getElementById('filterelementi').value;
         for (var i=1; i<11; i++) {
            if (ftr=="wildcard" && !document.getElementById(`marka${i}`).innerText.includes(val) &&
            !document.getElementById(`model${i}`).innerText.includes(val) &&
            !document.getElementById(`spol${i}`).innerText.includes(val) &&
            !document.getElementById(`velicina${i}`).innerText.includes(val) &&
            !document.getElementById(`godina${i}`).innerText.includes(val)&&
            !document.getElementById(`materijal${i}`).innerText.includes(val) &&
            !document.getElementById(`vrsta${i}`).innerText.includes(val) &&
            !document.getElementById(`visina${i}`).innerText.includes(val) &&
            !document.getElementById(`tip${i}`).innerText.includes(val)) document.getElementById(`red${i}`).remove();
            else if (ftr=="marka") {
               if (!document.getElementById(`marka${i}`).innerText.includes(val)) document.getElementById(`red${i}`).remove();
            }
            else if (ftr=="model") {
               if (!document.getElementById(`model${i}`).innerText.includes(val)) document.getElementById(`red${i}`).remove();
            }
            else if (ftr=="spol") {
               if (!document.getElementById(`spol${i}`).innerText.includes(val)) document.getElementById(`red${i}`).remove();
            }
            else if (ftr=="velicina") {
               if (!document.getElementById(`velicina${i}`).innerText.includes(val)) document.getElementById(`red${i}`).remove();
            }
            else if (ftr=="godina") {
               if (!document.getElementById(`godina${i}`).innerText.includes(val)) document.getElementById(`red${i}`).remove();
            }
            else if (ftr=="materijal") {
               if (!document.getElementById(`materijal${i}`).innerText.includes(val)) document.getElementById(`red${i}`).remove();
            }
            else if (ftr=="vrsta") {
               if (!document.getElementById(`vrsta${i}`).innerText.includes(val)) document.getElementById(`red${i}`).remove();
            }
            else if (ftr=="visina") {
               if (!document.getElementById(`visina${i}`).innerText.includes(val)) document.getElementById(`red${i}`).remove();
            }
            else if (ftr=="tip") {
               if (!document.getElementById(`tip${i}`).innerText.includes(val)) document.getElementById(`red${i}`).remove();
            }
         }
      }
      f.addEventListener('submit', submitted);
   </script>
</body>
</html>