// Build the chart
$(function () { 
Highcharts.chart('container', {
  chart: {
    plotBackgroundColor: null,
    plotBorderWidth: null,
    plotShadow: false,
    type: 'pie'
  },
  title: {
    text: '기부금 사용처'
  },
  tooltip: {
    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
  },
  accessibility: {
    point: {
      valueSuffix: '%'
    }
  },
  plotOptions: {
    pie: {
      allowPointSelect: true,
      cursor: 'pointer',
      dataLabels: {
        enabled: false
      },
      showInLegend: true
    }
  },
  series: [{
    name: 'Brands',
    colorByPoint: true,
    data: [{
      name: '어린이 도서관 건립',
      y: 42.41,
      sliced: true,
      selected: true
    }, {
      name: '문화발전 기금에 기부',
      y: 10.85
    }, {
      name: '예술가들을 위한 기금에 기부',
      y: 14.67
    }, {
      name: '혜화동 소극장 지원사업',
      y: 14.18
    }, {
      name: '한국을 빛낸 독립영화 지원사업',
      y: 17.05
    }]
  }]
});
});