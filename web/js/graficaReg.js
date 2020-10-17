/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


gvChartInit();
jQuery(document).ready(function(){
    jQuery('#myTable2').gvChart({
        chartType: 'ColumnChart',
        gvSettings: {
            colors:['#731E1A'],
            titleTextStyle:{
                color: '#516312',
                fontSize: '15'
            },
            vAxis: {
                title: 'CANTIDAD DE CASOS'
            },
            hAxis: {
                title: 'ESTATUS'
            },
            width: 700,
            height: 300
        }
    });

    jQuery('#myTable1').gvChart({
        chartType: 'PieChart',
        gvSettings: {
            colors:['#521411', '#731E1A','#892520','#9B2923','#AF312A','#D04139','#E55750','#F46D66','#F2807A','#F19591','#ECF9BF'],
            titleTextStyle:{
                color: '#516312',
                fontSize: '15'
            },
            vAxis: {
                title: 'CANTIDAD DE CASOS'
            },
            hAxis: {
                title: 'REGION'
            },
            width: 700,
            height: 300

        // chartArea:{width:"50%",height:"75%"}

        }
    });
    jQuery('#myTable4').gvChart({
        chartType: 'ColumnChart',
        gvSettings: {
            colors:['#731E1A'],
            titleTextStyle:{
                color: '#516312',
                fontSize: '15'
            },
            vAxis: {
                title: 'CANTIDAD DE CASOS'
            },
            hAxis: {
                title: 'INCIDENCIA'
            },
            width: 700,
            height: 300
        }
    });

    jQuery('#myTable3').gvChart({
        chartType: 'PieChart',
        gvSettings: {
            colors:['#521411', '#731E1A','#892520','#9B2923','#AF312A','#D04139','#E55750','#F46D66','#F2807A','#F19591','#ECF9BF'],
            titleTextStyle:{
                color: '#516312',
                fontSize: '15'
            },
            vAxis: {
                title: 'CANTIDAD DE CASOS'
            },
            hAxis: {
                title: 'REGION'
            },
            width: 700,
            height: 300

        // chartArea:{width:"50%",height:"75%"}

        }
    });
});