INSERT INTO diner_order (
    diner_order_id,
    diner_order_member_id,
    diner_id,
    diner_order_number,
    diner_order_date,
    total_amount,
    delete_yn,
    created_user_id,
    created_date_time,
    modified_user_id,
    modified_date_time
) VALUES
      (1, 1, 1, 1001, '2024-01-01 10:30:00', 150.75, 'N', 1, '2024-01-01 10:30:00', 1, '2024-01-01 10:30:00'),
      (2, 2, 1, 1002, '2024-01-02 11:15:00', 200.50, 'N', 1, '2024-01-02 11:15:00', 1, '2024-01-02 11:15:00'),
      (3, 3, 2, 1003, '2024-01-03 12:45:00', 99.99, 'N', 1, '2024-01-03 12:45:00', 1, '2024-01-03 12:45:00'),
      (4, 4, 2, 1004, '2024-01-04 14:00:00', 350.00, 'N', 1, '2024-01-04 14:00:00', 1, '2024-01-04 14:00:00'),
      (5, 5, 3, 1005, '2024-01-05 15:20:00', 125.30, 'N', 1, '2024-01-05 15:20:00', 1, '2024-01-05 15:20:00');

COMMIT;