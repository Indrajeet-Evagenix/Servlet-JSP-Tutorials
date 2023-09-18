

function countRows() {
	var a = document.getElementById("table1");
	let rows = a.rows.length;
	
	return confirm("Number of Rows are: " + rows);
}

var table = document.getElementById("table1");
var rowsPerPage = 5;
var rowCount = table.rows.length;
var tableHead = table.rows[0].firstElementChild.tagName === "th";
var tr = [];
var i, ii, j = (tableHead) ? 1 : 0;
var th = (tableHead ? table.rows[(0)].outerHTML : "");
var pageCount = Math.ceil(table.rows.length / rowsPerPage);

if (pageCount > 1) {
	for (i = j, ii = 0; i < rowCount; i++, ii++) {
		tr[ii] = table.rows[i].outerHTML;
	}
	table.insertAdjacentHTML("afterend", "<br><div id='buttons'></div>");
	sort(1);
}

function sort(page) {
	var rows = th, s = ((rowsPerPage * page) - rowsPerPage);
	for (i = s; i < (s + rowsPerPage) && i < tr.length; i++)
		rows += tr[i];
	table.innerHTML = rows;
	document.getElementById("buttons").innerHTML = pageButtons(pageCount, page);
}

function pageButtons(pageCount, current) {
	var prevButton = (current == 1) ? "disabled" : "";
	var nextButton = (current == pageCount) ? "disabled" : "";
	var buttons = "<input type='button' value='";
	for (i = 1; i <= pageCount; i++) {
		buttons += "";
	}
	buttons += "' onclick='sort(" + (current + 1) + ")' " + nextButton + ">";
	return buttons;
}


