package com.example.bienvenidoalcurso

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val VerdeTarjeta = Color(0xFF006D3B)
private val FondoTarjeta = Color(0xFFD2E8D4)

@Composable
fun TarjetaPresentacion(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(FondoTarjeta)
            .statusBarsPadding()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Parte de arriba: logo, nombre y cargo
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // LOGO DIBUJADO CON CÓDIGO (Reemplaza a R.drawable.androide)
            LogoAndroideDibujado()

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = "Cesar Augusto",
                fontSize = 44.sp,
                fontWeight = FontWeight.Light
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Estudiante de Ingeniería de Software",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = VerdeTarjeta
            )
        }

        // Parte de abajo: datos de contacto
        Column(modifier = Modifier.padding(bottom = 32.dp)) {
            FilaContacto(IconoTelefono, "+51 999 999 999")
            FilaContacto(IconoCompartir, "@camelotrees")
            FilaContacto(IconoCorreo, "correo@ejemplo.com")
        }
    }
}

@Composable
fun FilaContacto(icono: @Composable () -> Unit, texto: String) {
    Row(
        modifier = Modifier.padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(24.dp),
            contentAlignment = Alignment.Center
        ) {
            CompositionLocalProvider(LocalContentColor provides VerdeTarjeta) {
                icono()
            }
        }
        Spacer(modifier = Modifier.width(24.dp))
        Text(text = texto, fontSize = 16.sp)
    }
}

// --- DIBUJOS VECTORIALES (Sin usar R) ---

@Composable
fun LogoAndroideDibujado() {
    Canvas(modifier = Modifier.size(110.dp)) {
        val colorLogo = VerdeTarjeta
        val ancho = size.width
        val alto = size.height

        // Cabeza del androide (Semicírculo)
        drawArc(
            color = colorLogo,
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(ancho * 0.1f, alto * 0.2f),
            size = Size(ancho * 0.8f, alto * 0.6f)
        )

        // Ojos (Blancos)
        drawCircle(color = Color.White, radius = ancho * 0.06f, center = Offset(ancho * 0.35f, alto * 0.4f))
        drawCircle(color = Color.White, radius = ancho * 0.06f, center = Offset(ancho * 0.65f, alto * 0.4f))

        // Antenas
        drawLine(color = colorLogo, start = Offset(ancho * 0.3f, alto * 0.2f), end = Offset(ancho * 0.2f, alto * 0.05f), strokeWidth = 4.dp.toPx(), cap = StrokeCap.Round)
        drawLine(color = colorLogo, start = Offset(ancho * 0.7f, alto * 0.2f), end = Offset(ancho * 0.8f, alto * 0.05f), strokeWidth = 4.dp.toPx(), cap = StrokeCap.Round)

        // Cuerpo (Rectángulo redondeado)
        drawRoundRect(
            color = colorLogo,
            topLeft = Offset(ancho * 0.15f, alto * 0.5f),
            size = Size(ancho * 0.7f, alto * 0.4f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(10.dp.toPx(), 10.dp.toPx())
        )
    }
}

val IconoTelefono: @Composable () -> Unit = {
    Canvas(modifier = Modifier.size(24.dp)) {
        val strokeWidth = 2.dp.toPx()
        drawPath(
            path = Path().apply {
                moveTo(size.width * 0.2f, size.height * 0.2f)
                quadraticTo(size.width * 0.1f, size.height * 0.5f, size.width * 0.4f, size.height * 0.8f)
                lineTo(size.width * 0.8f, size.height * 0.8f)
            },
            color = VerdeTarjeta,
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
        )
    }
}

val IconoCompartir: @Composable () -> Unit = {
    Canvas(modifier = Modifier.size(24.dp)) {
        val strokeWidth = 2.dp.toPx()
        drawCircle(color = VerdeTarjeta, radius = 3.dp.toPx(), center = Offset(size.width * 0.2f, size.height * 0.5f))
        drawCircle(color = VerdeTarjeta, radius = 3.dp.toPx(), center = Offset(size.width * 0.8f, size.height * 0.2f))
        drawCircle(color = VerdeTarjeta, radius = 3.dp.toPx(), center = Offset(size.width * 0.8f, size.height * 0.8f))

        drawLine(color = VerdeTarjeta, start = Offset(size.width * 0.25f, size.height * 0.45f), end = Offset(size.width * 0.75f, size.height * 0.25f), strokeWidth = strokeWidth)
        drawLine(color = VerdeTarjeta, start = Offset(size.width * 0.25f, size.height * 0.55f), end = Offset(size.width * 0.75f, size.height * 0.75f), strokeWidth = strokeWidth)
    }
}

val IconoCorreo: @Composable () -> Unit = {
    Canvas(modifier = Modifier.size(24.dp)) {
        val strokeWidth = 2.dp.toPx()
        drawRect(
            color = VerdeTarjeta,
            topLeft = Offset(size.width * 0.1f, size.height * 0.25f),
            size = Size(size.width * 0.8f, size.height * 0.5f),
            style = Stroke(width = strokeWidth)
        )
        drawLine(
            color = VerdeTarjeta,
            start = Offset(size.width * 0.1f, size.height * 0.25f),
            end = Offset(size.width * 0.5f, size.height * 0.55f),
            strokeWidth = strokeWidth
        )
        drawLine(
            color = VerdeTarjeta,
            start = Offset(size.width * 0.9f, size.height * 0.25f),
            end = Offset(size.width * 0.5f, size.height * 0.55f),
            strokeWidth = strokeWidth
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTarjetaPresentacion() {
    TarjetaPresentacion()
}