package com.dazayamil.tiendabel.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record DailyReportResponseDTO (
        LocalDate date,
        int totalSales,
        BigDecimal totalRevenue,
        List<PaymentBreakdownDTO> paymentBreakdown
){}
