package com.controller;

	public class UpdateBidderException extends RuntimeException {

		public UpdateBidderException() {
			super("Bidder is not avliable in database to update");
		}
		
		@Override
		public String toString() {
			return "Bidder is not avliable in database to update";
		}

}
