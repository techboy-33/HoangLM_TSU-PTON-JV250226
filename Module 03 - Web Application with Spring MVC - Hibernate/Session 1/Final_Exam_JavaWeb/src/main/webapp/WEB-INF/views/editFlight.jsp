<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh sửa chuyến bay</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 30px 20px;
        }

        .container {
            max-width: 700px;
            margin: 0 auto;
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 40px rgba(0, 0, 0, 0.3);
            overflow: hidden;
        }

        .header {
            background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
            color: white;
            padding: 25px 30px;
            text-align: center;
        }

        .header h2 {
            font-size: 1.8em;
            font-weight: 600;
        }

        .form-content {
            padding: 30px;
        }

        .error {
            background: #f8d7da;
            color: #721c24;
            padding: 12px 15px;
            border-radius: 8px;
            margin-bottom: 20px;
            border-left: 4px solid #dc3545;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            font-weight: 600;
            color: #495057;
            margin-bottom: 8px;
            font-size: 0.95em;
        }

        .form-group input,
        .form-group select {
            width: 100%;
            padding: 12px 15px;
            border: 2px solid #dee2e6;
            border-radius: 8px;
            font-size: 1em;
            transition: all 0.3s ease;
            background: white;
        }

        .form-group input:focus,
        .form-group select:focus {
            outline: none;
            border-color: #f5576c;
            box-shadow: 0 0 0 3px rgba(245, 87, 108, 0.1);
        }

        .button-group {
            display: flex;
            gap: 15px;
            margin-top: 30px;
            padding-top: 20px;
            border-top: 2px solid #e9ecef;
        }

        .btn {
            flex: 1;
            padding: 14px 25px;
            border: none;
            border-radius: 8px;
            font-size: 1em;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            text-decoration: none;
            display: inline-block;
            text-align: center;
        }

        .btn-primary {
            background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
            color: white;
        }

        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(245, 87, 108, 0.4);
        }

        .btn-secondary {
            background: white;
            color: #f5576c;
            border: 2px solid #f5576c;
        }

        .btn-secondary:hover {
            background: #f5576c;
            color: white;
        }

        @media (max-width: 768px) {
            .container {
                margin: 0 10px;
            }

            .form-content {
                padding: 20px;
            }

            .button-group {
                flex-direction: column;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h2>✏️ Chỉnh sửa chuyến bay</h2>
    </div>

    <div class="form-content">
        <c:if test="${not empty error}">
            <div class="error">⚠️ ${error}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/flights/edit" method="post">
            <input type="hidden" name="flightId" value="${flight.flightId}"/>

            <div class="form-group">
                <label>Tên chuyến bay</label>
                <input type="text" name="flightName" value="${flight.flightName}" required maxlength="100" placeholder="VD: VN123 - Hà Nội - TP.HCM"/>
            </div>

            <div class="form-group">
                <label>Điểm xuất phát</label>
                <input type="text" name="startingPoint" value="${flight.startingPoint}" required maxlength="255" placeholder="VD: Sân bay Nội Bài, Hà Nội"/>
            </div>

            <div class="form-group">
                <label>Điểm đến</label>
                <input type="text" name="destination" value="${flight.destination}" required maxlength="255" placeholder="VD: Sân bay Tân Sơn Nhất, TP.HCM"/>
            </div>

            <div class="form-group">
                <label>Ngày khởi hành</label>
                <input type="date" name="departureDate" value="${flight.departureDate}" required/>
            </div>

            <div class="form-group">
                <label>Thời gian di chuyển</label>
                <input type="number" name="travelTime" min="1" value="${flight.travelTime}" required placeholder="Nhập số"/>
            </div>

            <div class="form-group">
                <label>Đơn vị thời gian</label>
                <select name="timeUnit">
                    <option value="hours" <c:if test="${flight.timeUnit=='hours'}">selected</c:if>>Giờ (Hours)</option>
                    <option value="minutes" <c:if test="${flight.timeUnit=='minutes'}">selected</c:if>>Phút (Minutes)</option>
                </select>
            </div>

            <div class="form-group">
                <label>Hình ảnh (URL)</label>
                <input type="text" name="travelImage" value="${flight.travelImage}" required placeholder="https://example.com/image.jpg"/>
            </div>

            <div class="form-group">
                <label>Trạng thái</label>
                <select name="status">
                    <option value="1" <c:if test="${flight.status==1}">selected</c:if>>✓ Hoạt động</option>
                    <option value="0" <c:if test="${flight.status==0}">selected</c:if>>✗ Không hoạt động</option>
                </select>
            </div>

            <div class="button-group">
                <button type="submit" class="btn btn-primary">✓ Cập nhật</button>
                <a href="${pageContext.request.contextPath}/flights" class="btn btn-secondary">← Quay lại</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>