package com.tsncg2023.DataIndicator.model;

import jakarta.persistence.*;
import lombok.*;

/** Data Model for View Repository
 * viewId: Id of the View such as V11
 * name: Name of the View
 * chartType: ChartType of the view such as Column
 * country: Country of the view such as IN
 * indicator: Indicator of the view such as 1.0.HCount.1.90usd
 * startDate: Start Date for the view
 * endDate: End Date for the view
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Views")
@Getter
@Setter
@ToString
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long viewId;

    private String name;

    private String chartType;

    private String country;

    private String indicator;

    private String startDate;

    private String endDate;
}
