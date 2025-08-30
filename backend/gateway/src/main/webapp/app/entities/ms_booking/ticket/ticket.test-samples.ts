import dayjs from 'dayjs/esm';

import { ITicket, NewTicket } from './ticket.model';

export const sampleWithRequiredData: ITicket = {
  id: '6288f68a-0c91-4447-84b6-ee245fb87118',
  scheduleId: '2727de82-1cf0-48b9-80d0-dc35391716c6',
  seatNumber: 'farm',
  seatType: 'FIRST_CLASS',
  price: 29866.34,
  status: 'EXPIRED',
  createdAt: dayjs('2025-08-29T21:54'),
  updatedAt: dayjs('2025-08-29T03:37'),
};

export const sampleWithPartialData: ITicket = {
  id: 'c742dfc8-30b4-4242-b0bf-ccf81ca55ad1',
  scheduleId: '3b8ac7af-5ec8-4815-8f22-cb83ff01dcb5',
  seatNumber: 'functional',
  seatType: 'FIRST_CLASS',
  price: 30556.66,
  status: 'CANCELLED',
  reservedUntil: dayjs('2025-08-29T08:01'),
  createdAt: dayjs('2025-08-29T03:44'),
  updatedAt: dayjs('2025-08-29T04:25'),
};

export const sampleWithFullData: ITicket = {
  id: '752d0453-09ab-4838-8064-f19bc83c813a',
  scheduleId: '64674ca3-4700-4bfd-883e-7e7cfdb7c13c',
  seatNumber: 'yahoo wrongly private',
  seatType: 'ECONOMY',
  price: 22086.89,
  status: 'EXPIRED',
  reservedUntil: dayjs('2025-08-29T21:07'),
  createdAt: dayjs('2025-08-29T06:24'),
  updatedAt: dayjs('2025-08-29T03:19'),
};

export const sampleWithNewData: NewTicket = {
  scheduleId: '83a8c9bf-c7cf-4893-8656-9809543c71be',
  seatNumber: 'gah',
  seatType: 'BUSINESS',
  price: 11316.97,
  status: 'EXPIRED',
  createdAt: dayjs('2025-08-29T06:58'),
  updatedAt: dayjs('2025-08-29T13:09'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
