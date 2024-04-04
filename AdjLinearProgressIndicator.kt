import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * An adjustable determinate linear progress indicator.
 * Accepts values greater than 1f.
 *
 * @param modifier The modifier to be applied to the indicator.
 * @param progress The progress of the indicator, between 0 and [totalProgress].
 * @param totalProgress The total progress the indicator can reach.
 * @param tipWidth The width the tip of the progress indicator where progress has reached.
 * @param tipColor The color of the tip.
 * @param progressColor The color of the progressed section of the indicator.
 * @param backgroundColor The color of the section between [progress] and [totalProgress].
 * @param cornerRadius The corner radius of each of the elements. To only apply corner radius
 * to the outside border use the clip modifier instead.
 */
@Composable
fun AdjLinearProgressIndicator(
    modifier: Modifier = Modifier,
    progress: Float,
    totalProgress: Float,
    tipWidth: Dp = 3.dp,
    tipColor: Color = MaterialTheme.colorScheme.onPrimary,
    progressColor: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    cornerRadius: Dp = 0.dp
) {
    Canvas(modifier = modifier.size(240.dp, 4.dp)) {
        val progression: Float =
            ((progress.coerceIn(0f, totalProgress)) / (totalProgress)) * size.width

        drawRoundRect( // Background
            cornerRadius = CornerRadius(cornerRadius.toPx()),
            color = backgroundColor,
            size = size
        )
        drawRoundRect( // Tip
            cornerRadius = CornerRadius(cornerRadius.toPx()),
            color = tipColor,
            size = Size(width = progression, height = size.height)
        )
        drawRoundRect( // Progress
            cornerRadius = CornerRadius(cornerRadius.toPx()),
            color = progressColor,
            size = Size(width = maxOf(0f, progression - tipWidth.toPx()), height = size.height)
        )
    }
}

/**
 * An adjustable determinate linear progress indicator.
 * Accepts values greater than 1f.
 *
 * @param modifier The modifier to be applied to the indicator.
 * @param progress The progress of the indicator, between 0 and [totalProgress].
 * @param totalProgress The total progress the indicator can reach.
 * @param tipWidth The width the tip of the progress indicator where progress has reached.
 * @param tipColor The color of the tip.
 * @param progressBrush The brush of the progressed section of the indicator.
 * @param backgroundBrush The brush of the section between [progress] and [totalProgress].
 * @param cornerRadius The corner radius of each of the elements. To only apply corner radius
 * to the outside border use the clip modifier instead.
 */
@Composable
fun AdjLinearProgressIndicator(
    modifier: Modifier = Modifier,
    progress: Float,
    totalProgress: Float,
    tipWidth: Dp = 3.dp,
    tipColor: Color = MaterialTheme.colorScheme.onPrimary,
    progressBrush: Brush,
    backgroundBrush: Brush,
    cornerRadius: Dp = 0.dp
) {
    Canvas(modifier = modifier.size(240.dp, 4.dp)) {
        val progression: Float = ((progress.coerceIn(0f, totalProgress)) / (totalProgress)) * size.width

        drawRoundRect( // Background
            cornerRadius = CornerRadius(cornerRadius.toPx()),
            brush = backgroundBrush,
            size = size
        )
        drawRoundRect( // Tip
            cornerRadius = CornerRadius(cornerRadius.toPx()),
            color = tipColor,
            size = Size(width = progression, height = size.height)
        )
        drawRoundRect( // Progress
            cornerRadius = CornerRadius(cornerRadius.toPx()),
            brush = progressBrush,
            size = Size(width = maxOf(0f, progression - tipWidth.toPx()), height = size.height)
        )
    }
}
