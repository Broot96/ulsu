package com.example.ulsu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "board_line_reply")
public class BrdLineReply extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRD_LINE_REPLY_SEQ", nullable = false)
    private Long brdLineReplySeq;

    @Column(name = "BRD_LINE_SEQ", nullable = false)
    private Long brdLineSeq;

    @Column(name = "BRD_HEADER_SEQ", nullable = false)
    private Long brdHeaderSeq;

    @Column(name = "BRD", nullable = false)
    private Long brd;
}
