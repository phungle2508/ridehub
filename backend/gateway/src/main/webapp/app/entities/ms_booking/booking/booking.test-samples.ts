import dayjs from 'dayjs/esm';

import { IBooking, NewBooking } from './booking.model';

export const sampleWithRequiredData: IBooking = {
  id: '2271f2b6-0a72-4448-abb3-9da5c45c62ef',
  userId: 'f49c40af-025c-43b4-ad7d-aad1ffa14062',
  scheduleId: '45cacc5a-106b-4fb0-9649-5fe43d3a79ff',
  ticketIds: '../fake-data/blob/hipster.txt',
  totalAmount: 26671.6,
  status: 'CONFIRMED',
  passengerDetails: '../fake-data/blob/hipster.txt',
  contactEmail: 'who schlep',
  contactPhone: 'misreport psst',
  bookingReference: 'really meh',
  createdAt: dayjs('2025-08-30T03:11'),
  updatedAt: dayjs('2025-08-30T11:22'),
  expiresAt: dayjs('2025-08-30T03:29'),
};

export const sampleWithPartialData: IBooking = {
  id: '0e175d1e-5362-46be-96c0-afb47770677c',
  userId: '41115fef-cbce-40e1-b16a-22f9df512bdb',
  scheduleId: 'b9c492d5-9abc-4471-8f66-74426e88bdb3',
  ticketIds: '../fake-data/blob/hipster.txt',
  totalAmount: 27016.01,
  status: 'CONFIRMED',
  passengerDetails: '../fake-data/blob/hipster.txt',
  contactEmail: 'noisily fully snoopy',
  contactPhone: 'athwart',
  bookingReference: 'icebreaker next',
  createdAt: dayjs('2025-08-30T11:58'),
  updatedAt: dayjs('2025-08-30T01:01'),
  expiresAt: dayjs('2025-08-30T06:13'),
};

export const sampleWithFullData: IBooking = {
  id: 'd8b667e1-e88f-45e1-864b-7ffb06754d71',
  userId: '5aa8d6bf-dc31-4257-87d9-e21b023c071b',
  scheduleId: 'a8622a2b-2938-47de-a38f-ab8840239ac2',
  ticketIds: '../fake-data/blob/hipster.txt',
  totalAmount: 5963.32,
  status: 'CONFIRMED',
  passengerDetails: '../fake-data/blob/hipster.txt',
  contactEmail: 'super going',
  contactPhone: 'yum profitable',
  bookingReference: 'within',
  createdAt: dayjs('2025-08-29T22:17'),
  updatedAt: dayjs('2025-08-30T08:47'),
  expiresAt: dayjs('2025-08-29T21:12'),
};

export const sampleWithNewData: NewBooking = {
  userId: '15deea85-7d2a-46e4-968a-1127f4087acf',
  scheduleId: '3e5035ca-79e5-4ef6-acf4-0299a5d8dd0a',
  ticketIds: '../fake-data/blob/hipster.txt',
  totalAmount: 32608.42,
  status: 'CONFIRMED',
  passengerDetails: '../fake-data/blob/hipster.txt',
  contactEmail: 'fat direct likewise',
  contactPhone: 'outsource',
  bookingReference: 'stunning cone step',
  createdAt: dayjs('2025-08-29T23:07'),
  updatedAt: dayjs('2025-08-30T05:30'),
  expiresAt: dayjs('2025-08-30T01:53'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
