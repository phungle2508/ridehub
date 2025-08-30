import dayjs from 'dayjs/esm';

import { ISchedule, NewSchedule } from './schedule.model';

export const sampleWithRequiredData: ISchedule = {
  id: '64a7231d-35cf-456b-98ca-3f5cab909dc9',
  routeId: '2e2002fc-7497-46c3-826d-cfc07c7b79a6',
  departureTime: dayjs('2025-08-29T01:40'),
  arrivalTime: dayjs('2025-08-29T17:19'),
  totalSeats: 15364,
  availableSeats: 27871,
  basePrice: 24516.89,
  isActive: true,
  createdAt: dayjs('2025-08-29T11:57'),
  updatedAt: dayjs('2025-08-29T23:36'),
};

export const sampleWithPartialData: ISchedule = {
  id: '64ccdbe0-1668-44f8-bba6-f90008ad05d9',
  routeId: '5718bb24-26cd-4851-ad79-3193ea47a675',
  departureTime: dayjs('2025-08-29T11:36'),
  arrivalTime: dayjs('2025-08-29T12:34'),
  totalSeats: 5209,
  availableSeats: 31832,
  basePrice: 10123.1,
  isActive: true,
  createdAt: dayjs('2025-08-29T17:42'),
  updatedAt: dayjs('2025-08-29T01:58'),
};

export const sampleWithFullData: ISchedule = {
  id: '5a565d23-7eec-4555-944c-e4838b9fa180',
  routeId: '7d031fb4-2c80-4e12-a485-943d986292d6',
  departureTime: dayjs('2025-08-29T13:40'),
  arrivalTime: dayjs('2025-08-29T12:19'),
  totalSeats: 3321,
  availableSeats: 9569,
  basePrice: 23696.08,
  isActive: false,
  createdAt: dayjs('2025-08-29T15:08'),
  updatedAt: dayjs('2025-08-29T22:21'),
};

export const sampleWithNewData: NewSchedule = {
  routeId: '47d5fe6f-4e76-470b-9c49-a7902c848590',
  departureTime: dayjs('2025-08-29T15:11'),
  arrivalTime: dayjs('2025-08-29T21:27'),
  totalSeats: 3825,
  availableSeats: 4545,
  basePrice: 26942.44,
  isActive: true,
  createdAt: dayjs('2025-08-29T14:02'),
  updatedAt: dayjs('2025-08-29T16:30'),
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
