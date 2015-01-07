package stein.paint.message;

import stein.paint.Canvas;

public class PaintMessageFactory {
	
	private Canvas canvas;

	public PaintMessageFactory(Canvas canvas){
		this.canvas = canvas;
	}
	
	public PaintMessage getMessage(String message) {

		PaintMessage paintMessage = null;
		String[] elements = message.split("\\s");

		switch (elements[0]) {

		case "LINE":
			paintMessage = new LineMessage(Integer.valueOf(elements[1]), Integer.valueOf(elements[2]),
					Integer.valueOf(elements[3]), Integer.valueOf(elements[4]), Integer.valueOf(elements[5]),
					Integer.valueOf(elements[5]));
			break;
		case "SHAPE":
			paintMessage = new ShapeMessage(elements[1], Integer.valueOf(elements[2]), Integer.valueOf(elements[3]),
					Integer.valueOf(elements[4]), Integer.valueOf(elements[5]), Integer.valueOf(elements[6]),
					Integer.valueOf(elements[7]), Boolean.valueOf(elements[8]));
			break;
		case "CLEAR":
			paintMessage = new ClearMessage();
			break;
		case "BUCKET_FILL":
			paintMessage = new BucketFillMessage(canvas, Integer.valueOf(elements[1]), Integer.valueOf(elements[2]),
					Integer.valueOf(elements[3]));
			break;

		}

		return paintMessage;

	}

}

// types - oval rect