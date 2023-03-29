// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

async function getDashboardInfo() {
  try {
    const response = await fetch('/api/dashboard/all');
    return await response.json();
  } catch (error) {
    console.log(err);
  }
}

(async () => {

  const entitysInfo = await getDashboardInfo();

  var ctx = document.getElementById("myPieChart");
  let myCreatedPieChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
      labels: ["Personagens", "Habilidades", "Personalidades", "Aparências", "Criadores", "Administradores"],
      datasets: [{
        data: [
          Number(entitysInfo.quantityPersonagens),
          Number(entitysInfo.quantityHabilidades),
          Number(entitysInfo.quantityPersonalidades),
          Number(entitysInfo.quantityAparencias),
          Number(entitysInfo.quantityCriadores),
          Number(entitysInfo.quantityAdministradores)
        ],
        backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc', '#cc3b36', '#fdba3a', '#5b4545'],
        hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
        hoverBorderColor: "rgba(234, 236, 244, 1)",
      }],
    },
    options: {
      maintainAspectRatio: false,
      tooltips: {
        backgroundColor: "rgb(255,255,255)",
        bodyFontColor: "#858796",
        borderColor: '#dddfeb',
        borderWidth: 1,
        xPadding: 15,
        yPadding: 15,
        displayColors: false,
        caretPadding: 10,
      },
      legend: {
        display: false
      },
      cutoutPercentage: 80,
    },
  });
})();

